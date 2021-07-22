//
/*
ID: 77617781
LANG: C
TASK: transform
*/

#include <stdio.h>
int n;
char original[11][11];
char after[11][11];

int isRo90(void);
int isRo180(void);
int isRo270(void);
int isreflect(void);
int iscombo(void);
int isno(void);

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("transform.in", "r");
    FILE *fout = fopen("transform.out", "w");
    fscanf(fin, "%d", &n);
    int i=0, j=0;
    int out=7;
    
    for (i=0; i<n; i++) {//read original
        fseek(fin, 1, SEEK_CUR);
        for (j=0; j<n; j++) {
            fscanf(fin, "%c", &original[i][j]);
        }
    }
    for (i=0; i<n; i++) {//read after
        fseek(fin, 1, SEEK_CUR);
        for (j=0; j<n; j++) {
            fscanf(fin, "%c", &after[i][j]);
        }
    }
    
    if (isRo90()) {
        out=1;
    }else if (isRo180()){
        out=2;
    }else if (isRo270()){
        out=3;
    }else if (isreflect()){
        out=4;
    }else if (iscombo()){
        out=5;
    }else if (isno()){
        out=6;
    }else{
        out=7;
    }
    fprintf(fout, "%d\n", out);
    
    fclose(fin);
    fclose(fout);
    return 0;
}

int isRo90(void){
    int i, j;
    for (i=0; i<n; i++) {
        for (j=0; j<n; j++) {
            if (after[j][n-1-i]!=original[i][j]) {
                return 0;
            }
        }
    }
    return 1;
}
int isRo180(void){
    int i, j;
    for (i=0; i<n; i++) {
        for (j=0; j<n; j++) {
            if (after[n-1-i][n-1-j]!=original[i][j]) {
                return 0;
            }
        }
    }
    return 1;
}
int isRo270(void){
    int i, j;
    for (i=0; i<n; i++) {
        for (j=0; j<n; j++) {
            if (after[n-1-j][i]!=original[i][j]) {
                return 0;
            }
        }
    }
    return 1;
}
int isreflect(void){
    int i, j;
    for (i=0; i<n; i++) {
        for (j=0; j<n; j++) {
            if (after[i][n-1-j]!=original[i][j]) {
                return 0;
            }
        }
    }
    return 1;
}
int iscombo(void){
    int i, j;
    char temp[11][11];
    for (i=0; i<n; i++) {
        for (j=0; j<n; j++) {
            temp[i][n-1-j]=original[i][j];
        }
    }
    int sta = 1;
    for (i=0; i<n; i++) {//90
        for (j=0; j<n; j++) {
            if (after[j][n-1-i]!=temp[i][j]) {
                sta = 0;
            }
        }
    }
    if (sta) {
        return 1;
    }
    sta = 1;
    for (i=0; i<n; i++) {//180
        for (j=0; j<n; j++) {
            if (after[n-1-i][n-1-j]!=temp[i][j]) {
                sta = 0;
            }
        }
    }
    if (sta) {
        return 1;
    }
    for (i=0; i<n; i++) {//270
        for (j=0; j<n; j++) {
            if (after[n-1-j][i]!=temp[i][j]) {
                return 0;
            }
        }
    }
    return 1;
}
int isno(void){
    int i, j;
    for (i=0; i<n; i++) {
        for (j=0; j<n; j++) {
            if (after[i][j]!=original[i][j]) {
                return 0;
            }
        }
    }
    return 1;
}
