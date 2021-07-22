//
/*
ID: 77617781
LANG: C
TASK: beads
*/

#include <stdio.h>
#include <string.h>
int numofbeads = 0;
int forecount(int i, char beads[]);
int aftercount(int i, char beads[]);

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("beads.in", "r");
    FILE *fout = fopen("beads.out", "w");
    int i = 0;
    
    fscanf(fin, "%d", &numofbeads);
    char beads[numofbeads*2+1];
    fscanf(fin, "%s", beads);
    for (i=numofbeads; i<numofbeads*2; i++) {
        beads[i] = beads[i-numofbeads];
    }
    
    int max = 1;
    int c_len = 1;
    
    for (i=1; i<numofbeads*2; i++) {
        if (beads[i] != beads[i-1]) {
            c_len = forecount(i, beads)+aftercount(i, beads);
            if (c_len > max) {
                max = c_len;
            }
            c_len = 1;
        }
        if (max==1 && i==numofbeads*2-1) {
            c_len = forecount(i, beads)+aftercount(i, beads);
            if (c_len > max) {
                max = c_len;
            }
            c_len = 1;
        }
    }
    
    if (max>numofbeads) {
        max = numofbeads;
    }
    
    fprintf(fout, "%d\n", max);
    
    fclose(fin);
    fclose(fout);
    return 0;
}

int forecount(int i, char beads[]){
    int a = 0;
    int j = 0;
    char index = beads[i-1];
    
    for (j=i-1; j>=0; j--) {
        if (beads[j]==index || beads[j]=='w') {
            a++;
        }else if(index=='w'){
            index = beads[j];
            a++;
        }else{
            break;
        }
    }
    return a;
}
    
int aftercount(int i, char beads[]){
    int b = 0;
    int j = 0;
    char index = beads[i];
    
    for (j=i; j<numofbeads*2; j++) {
        if (beads[j]==beads[i] || beads[j]=='w') {
            b++;
        }else if(index=='w'){
            index = beads[j];
            b++;
        }else{
            break;
        }
    }
    return b;
}
