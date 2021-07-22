//
/*
ID: 77617781
LANG: C
TASK: milk2
*/

#include <stdio.h>
#include <assert.h>
struct time{
    int start;
    int end;
};
void sort(struct time farmer[], int numOFfarmers);
void input(struct time farmer[], int numOFfarmers, FILE *fin);

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("milk2.in", "r");
    FILE *fout = fopen("milk2.out", "w");
    assert(fin != NULL && fout != NULL);
    
    int numOFfarmers = 0;
    fscanf(fin, "%d", &numOFfarmers);
    struct time farmer[numOFfarmers];
    input(farmer, numOFfarmers, fin);
    sort(farmer, numOFfarmers);
    
    int maxmilk = 0, maxidle = 0;
    int c_milk = farmer[0].end-farmer[0].start, c_idle = 0;
    int i;
    int latestend = farmer[0].end;
    
    for (i=1; i<numOFfarmers; i++) {
        if (latestend < farmer[i].end) {
            if (latestend >= farmer[i].start) {
                c_milk += farmer[i].end-latestend;
            }else{
                if (maxmilk < c_milk) {
                    maxmilk = c_milk;
                }
                c_milk = farmer[i].end-farmer[i].start;
                c_idle = farmer[i].start-latestend;
                if (maxidle < c_idle) {
                    maxidle = c_idle;
                }
            }
            latestend = farmer[i].end;
        }
    }
    
    if (maxmilk < c_milk) {//prevent continuous milking the whole time
        maxmilk = c_milk;
    }
    
    fprintf(fout, "%d %d\n", maxmilk, maxidle);
    
    fclose(fin);
    fclose(fout);
    return 0;
}

void sort(struct time farmer[], int numOFfarmers) {
    int i, j;
    struct time temp;
    
    for (i=0; i<numOFfarmers-1; i++) {
        for (j=i+1; j<numOFfarmers; j++) {
            if (farmer[i].start>farmer[j].start) {
                temp = farmer[i];
                farmer[i] = farmer[j];
                farmer[j] = temp;
            }
        }
    }
    return;
}
void input(struct time farmer[], int numOFfarmers, FILE *fin){
    int i;
    for (i=0; i<numOFfarmers; i++) {
        fscanf(fin, "%d", &farmer[i].start);
        fscanf(fin, "%d", &farmer[i].end);
    }
    return;
}
