//
/*
ID: 77617781
LANG: C
TASK:
*/

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("gymnastics.in", "r");
    FILE *fout = fopen("gymnastics.out", "w");
    int k=0, n=0;
    fscanf(fin, "%d %d", &k, &n);
    int ranks[10][20];
    memset(ranks, 0, 200*sizeof(int));
    int i=0, j=0, a=0, b=0;
    
    for (i=0; i<k; i++) {
        for (j=0; j<n; j++) {
            
            fscanf(fin, "%d", &ranks[i][j]);
        }
    }
    
    int pairs=0;
    int better[k];
    int ispair = 0;
    
    for (i=1; i<=n; i++) {
        for (j=1; j<=n; j++) {
            if (i == j) {
                continue;
            }
            memset(better, 0, k*sizeof(int));
            ispair = 1;
            for (a=0; a<k; a++) {
                for (b=0; b<n; b++) {
                    if (ranks[a][b]==i) {
                        better[a] = 1;
                        break;
                    }else if (ranks[a][b]==j){
                        better[a] = 0;
                        break;
                    }
                }
            }
            for (b=0; b<k; b++) {
                if (better[b]==0) {
                    ispair = 0;
                    break;
                }
            }
            if (ispair) {
                pairs++;
            }
        }
    }
    
    fprintf(fout, "%d\n", pairs);
    
    fclose(fin);
    fclose(fout);
    return 0;
}
