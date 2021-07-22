//
/*
ID: 77617781
LANG: C
TASK: badmilk
*/

#include <stdio.h>
#include <string.h>
struct tastes{
    int person;
    int milktype;
    int time;
};
struct sicks{
    int person;
    int time;
};

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("badmilk.in", "r");
    FILE *fout = fopen("badmilk.out", "w");
    int numOFfriends=0, m=0, tastes=0, sicks=0;
    int i=0, j=0, k=0;
    fscanf(fin, "%d %d %d %d", &numOFfriends, &m, &tastes, &sicks);
    struct tastes tas[tastes];
    struct sicks sik[sicks];
    
    for (i=0; i<tastes; i++) {
        fscanf(fin, "%d %d %d", &tas[i].person, &tas[i].milktype, &tas[i].time);
    }
    for (i=0; i<sicks; i++) {
        fscanf(fin, "%d %d", &sik[i].person, &sik[i].time);
    }
    
    int suschart[m];
    int drank_it = 0;
    int thismilk = 1;
    int tempdose = 0, maxdose = 0;
    int poorpeople[numOFfriends];
    memset(suschart, 0, m*sizeof(int));
    memset(poorpeople, 0, numOFfriends*sizeof(int));
    
    for (i=0; i<m; i++) {//loop for milk
        thismilk = 1;
        for (j=0; j<sicks; j++) {//loop for sick person
            drank_it = 0;
            for (k=0; k<tastes; k++) {//see if he drank it
                if (sik[j].person == tas[k].person && sik[j].time > tas[k].time && i+1 == tas[k].milktype && drank_it == 0) {
                    drank_it = 1;
                }
            }
            if (drank_it == 0) {
                thismilk = 0;
                break;
            }
        }
        if (thismilk) {
            tempdose = 0;
            for (j=0; j<tastes; j++) {//count how many people drank it
                if (i+1 == tas[j].milktype && poorpeople[tas[j].person-1] == 0) {
                    tempdose++;
                    poorpeople[tas[j].person-1] = 1;
                }
            }
            if (tempdose > maxdose) {
                maxdose = tempdose;
            }
        }
    }
    
    fprintf(fout, "%d\n", maxdose);
    
    fclose(fin);
    fclose(fout);
    return 0;
}
