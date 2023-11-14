package com.home.projects.groceriesapp.scheduler;

import com.home.projects.groceriesapp.data.model.ShoppingList;
import com.home.projects.groceriesapp.data.repository.ShoppingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class ShoppingListGeneratorScheduler implements SchedulingConfigurer {

    private final ShoppingListRepository shoppingListRepository;

    private final Logger logger = LoggerFactory.getLogger(ShoppingListGeneratorScheduler.class);


    public ShoppingListGeneratorScheduler(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(
                this::initializeNewShoppingList,
                triggerContext -> {

                    if (triggerContext.lastCompletion() == null) {
                        return new Date().toInstant();
                    }
                    return Objects.requireNonNull(triggerContext.lastCompletion()).plusMillis(getMillisDelay());
                }
        );
    }

    private void initializeNewShoppingList() {

        var oldShoppingList = shoppingListRepository.findShoppingListByActive(true);

        oldShoppingList.ifPresent(shoppingList -> {
            shoppingList.setActive(false);
            shoppingListRepository.save(oldShoppingList.get());
            logger.info("Old shopping list deactivated: " + shoppingList.getId());
        });

        var newShoppingList = ShoppingList.builder()
                .active(true)
                .name("Shopping List")
                .creationDate(Date.from(Instant.now()))
                .build();

        shoppingListRepository.save(newShoppingList);

        logger.info("New shopping list created: " + newShoppingList.getId());
    }

    private Long getMillisDelay() {
        Calendar with = Calendar.getInstance();
        Map<Integer, Integer> dayToDelay = new HashMap<Integer, Integer>();
        dayToDelay.put(Calendar.FRIDAY, 2);
        dayToDelay.put(Calendar.SATURDAY, 1);
        dayToDelay.put(Calendar.SUNDAY, 0);
        dayToDelay.put(Calendar.MONDAY, 6);
        dayToDelay.put(Calendar.TUESDAY, 5);
        dayToDelay.put(Calendar.WEDNESDAY, 4);
        dayToDelay.put(Calendar.THURSDAY, 3);
        int dayOfWeek = with.get(Calendar.DAY_OF_WEEK);
        int hour = with.get(Calendar.HOUR_OF_DAY);
        int delayInDays = dayToDelay.get(dayOfWeek);

        if (delayInDays == 6 && hour < 11) {
            return (11 - hour) * 3600 * 1000L;
        } else {
            return delayInDays * 24L + ((24 - hour) + 11) * 3600 * 1000L;
        }
    }
}