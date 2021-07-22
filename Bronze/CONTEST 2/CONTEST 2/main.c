//
/*
ID: 77617781
LANG: C
TASK: exp
*/

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("whereami.in", "r");
    FILE *fout = fopen("whereami.out", "w");
    int road = 0;
    fscanf(fin, "%d", &road);
    fseek(fin, 1, SEEK_CUR);
    char mailbox[road+2];
    memset(mailbox, '\0', (road+1)*sizeof(char));
    int i=1, j=1, k=0, l=0;
    for (i=1; i<=road; i++) {
        fscanf(fin, "%c", &mailbox[i]);
    }
    
    int length = 1;
    int match = 0;
    char temp[road];
    char current[road];
    
    for (length=1; length<=road; length++) {
        
        match = 0;
        for (i=1; i<=road+1-length-length; i++) {
            
            memset(current, '\0', road*sizeof(char));
            for (k=i, l=0; k<i+length; k++, l++) {
                current[l]=mailbox[k];
            }
            
            for (j=i+length; j<=road+length-1; j++) {
                memset(temp, '\0', road*sizeof(char));
                for (k=j, l=0; k<j+length; k++, l++) {
                    temp[l]=mailbox[k];
                }
                if (strcmp(temp, current)==0) {
                    match++;
                }
                
            }
        }
        
        if (match==0) {
            break;
        }
    }
    int all = 1;
    for (i=1; i<=road; i++) {
        for (j=1; j<=road; j++) {
            if (mailbox[i]!=mailbox[j]) {
                all=0;
            }
        }
    }
    if (all==1) {
        length=road;
    }
    
    fprintf(fout, "%d\n", length);
    
    fclose(fin);
    fclose(fout);
    return 0;
}
