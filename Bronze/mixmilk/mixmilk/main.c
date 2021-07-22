//
/*
ID: 77617781
LANG: C
TASK: mixmilk
*/

#include <stdio.h>
struct buckets{
    int amount;
    int capacity;
};

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("mixmilk.in", "r");
    FILE *fout = fopen("mixmilk.out", "w");
    struct buckets bucket[3];
    int i = 0;
    int receive = 0, give = 0;
    
    for (i=0; i<3; i++) {//input
        fscanf(fin, "%d %d", &bucket[i].capacity, &bucket[i].amount);
    }
    for (i=0; i<100; i++) {
        give = i%3;
        receive = (i+1)%3;
        if (bucket[give].amount+bucket[receive].amount > bucket[receive].capacity) {
            bucket[give].amount = bucket[give].amount - (bucket[receive].capacity-bucket[receive].amount);//substract
            bucket[receive].amount = bucket[receive].capacity;//add
        }else if(bucket[give].amount+bucket[receive].amount <= bucket[receive].capacity){
            bucket[receive].amount += bucket[give].amount;//add
            bucket[give].amount = 0;//none left
        }
        if (bucket[receive].amount > bucket[receive].capacity) {
            printf("error\n");
        }
    }
    for (i=0; i<3; i++) {
        fprintf(fout, "%d\n", bucket[i].amount);
    }
    
    fclose(fin);
    fclose(fout);
    return 0;
}
