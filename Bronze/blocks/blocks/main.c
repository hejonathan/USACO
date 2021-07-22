//
/*
ID: 77617781
LANG: C
TASK: blocks
*/

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("blocks.in", "r");
    FILE *fout = fopen("blocks.out", "w");
    int n = 0;
    fscanf(fin, "%d", &n);
    int i = 0, j= 0;
    int singleboard[100][26] = {0};
    char temp1[11], temp2[11];
    int line[2][26] = {0};
    int boards[26];
    memset(boards, 0, 26*sizeof(int));
    
    for (i=0; i<n; i++) {
        memset(temp1, '\0', 11*sizeof(char));
        memset(temp2, '\0', 11*sizeof(char));
        memset(line[0], 0, 26*sizeof(int));
        memset(line[1], 0, 26*sizeof(int));
        fscanf(fin, "%s %s", temp1, temp2);
        
        for (j=0; temp1[j]!='\0'; j++) {
            line[0][ temp1[j]-'a' ]++;//add letters
        }
        for (j=0; temp2[j]!='\0'; j++) {
            line[1][ temp2[j]-'a' ]++;//add letters
        }
        for (j=0; j<26; j++) {
            if (line[0][j] > line[1][j]) {
                singleboard[i][j] = line[0][j];
            }else{
                singleboard[i][j] = line[1][j];
            }
        }
    }
    for (j=0; j<26; j++) {
        for (i=0; i<n; i++) {
            boards[j] += singleboard[i][j];
        }
        fprintf(fout, "%d\n", boards[j]);
    }
    
    fclose(fin);
    fclose(fout);
    return 0;
}
