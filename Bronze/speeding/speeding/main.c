//
/*
ID: 77617781
LANG: C
TASK: speeding
*/

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("speeding.in", "r");
    FILE *fout = fopen("speeding.out", "w");
    int speedlimit[101];
    int bessiespeed[101];
    memset(speedlimit, 0, 101*sizeof(int));
    memset(bessiespeed, 0, 101*sizeof(int));
    int n = 0, m = 0;
    int i = 0, j = 1;;
    fscanf(fin, "%d %d", &n, &m);
    int tlength = 0, tspeed = 0, position = 1;
    
    for (i=0; i<n; i++) {
        fscanf(fin, "%d %d", &tlength, &tspeed);
        for (j=0; j<tlength; j++, position++) {
            speedlimit[position] = tspeed;
        }
    }
    position = 1;
    for (i=0; i<m; i++) {
        fscanf(fin, "%d %d", &tlength, &tspeed);
        for (j=0; j<tlength; j++, position++) {
            bessiespeed[position] = tspeed;
        }
    }
    
    int maxover = 0, c_over = 0;
    for (i=1; i<=100; i++) {
        if (bessiespeed[i] > speedlimit[i]) {
            c_over = bessiespeed[i] - speedlimit[i];
            if (c_over > maxover) {
                maxover = c_over;
            }
        }
    }
    fprintf(fout, "%d\n", maxover);
    
    fclose(fin);
    fclose(fout);
    return 0;
}
