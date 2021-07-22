//
/*
ID: 77617781
LANG: C
TASK: backforth
*/

#include <stdio.h>
int posi[10000] = {0};
int a = 0;
void many(int firstbarn);

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("backforth.in", "r");
    FILE *fout = fopen("backforth.out", "w");
    
    int firstbu[10] = {0}, secondbu[11] = {0};
    int firstbucket[10]={0}, secondbucket[10]={0};
    int firstbarn = 1000;
    int i=0, j=0, k=0, l=0;
    int x=0, y=0, z=0;
    for (i=0; i<10; i++) {
        fscanf(fin, "%d", &firstbucket[i]);
    }
    for (i=0; i<10; i++) {
        fscanf(fin, "%d", &secondbucket[i]);
    }
    
    for (i=0; i<10; i++) {
        for (j=0; j<10; j++) {
            firstbu[j] = firstbucket[j];
            secondbu[j] = secondbucket[j];
        }
        firstbarn -= firstbu[i];
        
        for (j=0; j<11; j++) {
            secondbu[10] = firstbu[i];
            x = secondbu[j];
            firstbarn += secondbu[j];
            firstbu[i] = secondbu[j];
            secondbu[j] = secondbu[10];
            for (k=0; k<10; k++) {
                y = firstbu[k];
                firstbarn -= firstbu[k];
                secondbu[10] = firstbu[k];
                for (l=0; l<11; l++) {
                    z = secondbu[l];
                    firstbarn += secondbu[l];
                    many(firstbarn);
                    firstbarn -= z;
                }
                firstbarn += y;
            }
            firstbarn -= x;
        }
        firstbarn = 1000;//back to original value
    }
    fprintf(fout, "%d\n", a);
    
    fclose(fin);
    fclose(fout);
    return 0;
}
void many(int firstbarn){
    int i = 0;
    int d = 0;
    for (i=0; posi[i]!=0; i++) {
        if (firstbarn == posi[i]) {
            d = 1;
            break;
        }
    }
    if (d == 0) {
        a++;
        posi[i] = firstbarn;
        printf("%d\n", firstbarn);
        
    }
    return;
}
