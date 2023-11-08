    Ideea este ca eu vreau ca acest ShoppingListItemRequest sa vina din FE.

    * Cand eu creez un nou Grocery, o sa am optiunea
                            -> sa il adaug in Shopping List direct
                            -> doar sa il salvez

    * Cand vad toate groceries, voi avea un semn de + care, atunci ca il voi apasa, imi va aparea inca un box unde voi
    putea introduce cantitatea si daca nu o voi introduce, mi se va pute automat '1' atunci cand mai apas inca o data pe +.

    * Cand voi apasa pentru a doua oara pe +, se va trimite un request la /api/v1/shoping-list cu un ShoppingListItemRequest
    eu voi cauta sa vad daca exista deja un shopping list creeat pe saptamana asta. daca exista, voi cauta sa vad daca are
    deja un grocery de acel tip, iar daca este, voi trimite un pop-up cu 'acest item este deja in basket. Vrei sa schimbi cantitatea? '
    si voi avea un raspuns unde se va putea face submit la noua cantitate.


    *Altfel creez un nou shopping list.

    @In dreapta ecranului voi avea afisat shopping list de saptamana asta impreuna cu ShoppingListItem-urile lui.