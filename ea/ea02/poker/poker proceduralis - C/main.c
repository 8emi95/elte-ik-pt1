#include <stdio.h>
#include <stdlib.h>
#include <time.h>


typedef struct _player{
    int money;
    char name[12];
};

typedef struct _player* Player;

int playernum = 0;
Player* players;
int bid;


int endgame(){
    int loosercount = 0;

    int j;
    for(j = 0; j< playernum; j++){
        if(players[j] == NULL)
            loosercount += 1;
    }

    if(loosercount == playernum-1){
        return 1;
    }else{
        return 0;
    }
}

void init(){
    printf("Number of players: ");
    scanf("%d", &playernum);
    players = malloc(sizeof(Player)*playernum);

    int money;
    printf("Enter money for players : ");
    scanf("%d", &money);

    while(1){
        printf("Enter bid: ");
        scanf("%d", &bid);
        if(money % bid == 0){
            break;
        }
        printf("Bid must be the divisor of money!\n");
    }

    int j;
    for(j = 0; j < playernum; j++){
        Player p = malloc(sizeof(struct _player));
        printf("Enter %d. player name: ", j+1);
        scanf("%s", p->name);
        p->money = money;
        players[j] = p;
    }
}

void writeout_players(){
    int j;
    for(j = 0; j < playernum; j++){
        if(players[j] != NULL)
            printf("%s has $%d\n", players[j]->name, players[j]->money);
    }
}

void remove_loosers(){
    int j;
    for(j = 0; j < playernum; j++){
        if(players[j] != NULL && players[j]->money == 0){
            printf("--%s looses\n", players[j]->name);
            players[j] = NULL;
        }
    }
}

int take_bids(){
    int j;
    int pot = 0;
    for(j = 0; j < playernum; j++){
        if(players[j] != NULL){
            players[j]->money -= bid;
            pot += bid;
        }
    }
    return pot;
}

int calculate_winner(){
    int randnum;

    while(1){
        randnum = rand() % playernum;
        if(players[randnum] != NULL)
            return randnum;
    }
}

void giveplayer_prize(winnerid, pot){
    players[winnerid]->money += pot;
}

void writeout_winner(){
    int j = 0;
    while(players[j] == NULL){
        j++;
    }
    printf("The winner is %s", players[j]->name);
}

int main()
{
    srand(time(NULL));
    init();
    int roundnum = 1;
    while(!endgame()){
        printf("Round %d\n", roundnum);
        writeout_players();
        int pot = take_bids();
            printf("\tThe pot is %d\n", pot);
        int winner_id = calculate_winner();
            printf("\tThe winner is %s\n", players[winner_id]->name);
        giveplayer_prize(winner_id, pot);
        remove_loosers();
        roundnum++;
    }
    writeout_winner();
    return 0;
}
