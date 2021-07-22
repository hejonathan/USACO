//
/*
ID: 77617781
LANG: C
TASK: shuffle
*/

#include <stdio.h>


int main(int argc, const char * argv[]) {
    int i = 0, n = 0, j = 0, k = 0;
    
    FILE *fin = fopen("shuffle.in", "r");
    FILE *fout = fopen("shuffle.out", "w");
    fscanf(fin, "%d", &n);
    int idnum[100] = {0};
    int newid[100] = {0};
    int swap[100] = {0};
    
    for (i=0; i<n; i++) {
        fscanf(fin, "%d", &swap[i]);
    }
    for (i=0; i<n; i++) {
        fscanf(fin, "%d", &idnum[i]);
    }
    
    for (i=0; i<3; i++) {
        for (j=0; j<n; j++) {
            newid[j] = idnum[swap[j]-1];
        }
        for (k=0; k<n; k++) {
            idnum[k] = newid[k];
            newid[k] = 0;
        }
    }
    
    for (i=0; i<n; i++) {
        fprintf(fout, "%d\n", idnum[i]);
    }
    
    fclose(fin);
    fclose(fout);
    return 0;
}

