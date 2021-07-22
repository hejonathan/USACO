//
/*
ID: 77617781
LANG: C
TASK: dualpal
*/

#include <stdio.h>
#include <string.h>
char aft[64];
void tobase(long ori, int base);
int ispal(char aft[]);

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("dualpal.in", "r");
    FILE *fout = fopen("dualpal.out", "w");
    int i = 0, n = 0, st = 0, a = 0;
    int c_num = 0;
    int base = 0;
    
    fscanf(fin, "%d %d", &n, &st);
    
    for (i=0, c_num=st+1; i<n; c_num++) {
        for (base=2; base<=10; base++) {
            tobase(c_num, base);
            if (ispal(aft)) {
                a++;
                if (a>=2) {
                    fprintf(fout, "%d\n", c_num);
                    i++;
                    a=0;
                    break;
                }else if (a<2&&base==10){
                    continue;
                }
            }
        }
        a = 0;
    }
    
    fclose(fin);
    fclose(fout);
    return 0;
}

void tobase(long ori, int base){
    memset(aft, '\0', 64*sizeof(char));
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
        aft[j] = digits[reverse[i]];
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
