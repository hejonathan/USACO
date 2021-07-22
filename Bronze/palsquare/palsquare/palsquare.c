//
/*
ID: 77617781
LANG: C
TASK: palsquare
*/

#include <stdio.h>
#include <string.h>
void tobase(long ori, int base, char basenum[]);
int ispal(char aft[]);

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("palsquare.in", "r");
    FILE *fout = fopen("palsquare.out", "w");
    int i = 0;
    int b = 0;
    char basei[64] = {'\0'}, basei2[64] = {'\0'};
    fscanf(fin, "%d", &b);
    for (i=1; i<=300; i++) {
        tobase(i, b, basei);
        tobase(i*i, b, basei2);
        if (ispal(basei2)) {
            fprintf(fout, "%s %s\n", basei, basei2);
        }
    }
    
    
    fclose(fin);
    fclose(fout);
    return 0;
}

void tobase(long ori, int base, char basenum[]){
    memset(basenum, '\0', 64*sizeof(char));
    char digits[20] =
      {'0', '1', '2', '3', '4', '5', '6', '7',
       '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
       'G', 'H', 'I', 'J'};

    int reverse[64] = {0};
    int i=0, j=0;

    /* convert to the indicated base */
    while (ori != 0){
        reverse[i] = ori % base;
        ori = ori / base;
        i++;
    }

    i--;  //back up to last entry
    for(j=0; i>=0; i--, j++){ //go backward through array
        basenum[j] = digits[reverse[i]];
    }
    return;
}

int ispal(char aft[]){
    char pas[64] = {'\0'};
    int i = 0, j = 0;
    for (i=0; i<64; i++) {
        if (aft[i]=='\0') {
            i--;
            break;
        }
    }
    for (j=0; i>=0; j++, i--) {
        pas[j]=aft[i];
    }
    if (strcmp(pas, aft)==0) {
        return 1;
    }
    return 0;
}
