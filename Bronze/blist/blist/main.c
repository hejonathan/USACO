//
/*
ID: 77617781
LANG: C
TASK: blist
*/

#include <stdio.h>
struct cows{
    int start;
    int end;
    int buckets;
};
void sort(struct cows cow[], int n);
int main(int argc, const char * argv[]) {
    FILE *fin = fopen("blist.in", "r");
    FILE *fout = fopen("blist.out", "w");
    int n = 0;
    int i = 0, j = 0;
    fscanf(fin, "%d", &n);
    struct cows cow[n];
    for (i=0; i<n; i++) {
        fscanf(fin, "%d %d %d", &cow[i].start, &cow[i].end, &cow[i].buckets);
    }
    int c_bucket = cow[0].buckets, max_bucket = 0;
    sort(cow, n);
    
    for (i=0; i<n; i++) {
        c_bucket = cow[i].buckets;
        for (j=0; j<i; j++) {
            if (cow[i].start < cow[j].end) {
                c_bucket += cow[j].buckets;
            }
        }
        if (c_bucket > max_bucket) {
            max_bucket = c_bucket;
            c_bucket = 0;
        }
    }
    fprintf(fout, "%d\n", max_bucket);
    
    
    fclose(fin);
    fclose(fout);
    return 0;
}

void sort(struct cows cow[], int n){
    int i = 0, j = 0;
    struct cows temp;
    for (i=0; i<n-1; i++) {
        for (j=i+1; j<n; j++) {
            if (cow[j].start < cow[i].start) {
                temp = cow[i];
                cow[i] = cow[j];
                cow[j] = temp;
            }
        }
    }
    return;
}
