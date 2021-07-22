//
/*
ID: 77617781
LANG: C
TASK: lineup
*/
/*
 1 Beatrice
 2 Belinda
 3 Bella
 4 Bessie
 5 Besty
 6 Blue
 7 Buttercup
 8 Sue
 */

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("lineup.in", "r");
    FILE *fout = fopen("lineup.out", "w");
    int i=0, j=0;
    int constraints = 0;
    fscanf(fin, "%d", &constraints);
    int con[constraints][2];
    char temp1[10], temp2[10];
    int t1=0, t2=0;
    memset(con, 0, constraints*2*sizeof(int));

    for (i=0; i<constraints; i++) {
        memset(temp1, '\0', 10*sizeof(char));
        memset(temp2, '\0', 10*sizeof(char));
        t1 = 0;
        t2 = 0;
        fscanf(fin, "%s", temp1);
        fseek(fin, 22, SEEK_CUR);
        fscanf(fin, "%s", temp2);
        if (strcmp(temp1, "Beatrice\0")==0) {
            t1=1;
        }else if (strcmp(temp1, "Belinda\0")==0){
            t1=2;
        }else if (strcmp(temp1, "Bella\0")==0){
            t1=3;
        }else if (strcmp(temp1, "Bessie\0")==0){
            t1=4;
        }else if (strcmp(temp1, "Betsy\0")==0){
            t1=5;
        }else if (strcmp(temp1, "Blue\0")==0){
            t1=6;
        }else if (strcmp(temp1, "Buttercup\0")==0){
            t1=7;
        }else if (strcmp(temp1, "Sue\0")==0){
            t1=8;
        }
        if (strcmp(temp2, "Beatrice\0")==0) {
            t2=1;
        }else if (strcmp(temp2, "Belinda\0")==0){
            t2=2;
        }else if (strcmp(temp2, "Bella\0")==0){
            t2=3;
        }else if (strcmp(temp2, "Bessie\0")==0){
            t2=4;
        }else if (strcmp(temp2, "Betsy\0")==0){
            t2=5;
        }else if (strcmp(temp2, "Blue\0")==0){
            t2=6;
        }else if (strcmp(temp2, "Buttercup\0")==0){
            t2=7;
        }else if (strcmp(temp2, "Sue\0")==0){
            t2=8;
        }
        
        con[i][0]=t1;
        con[i][1]=t2;
    }
    int c[9];
    int order[9];
    int status[9];
    memset(c, 0, 9*sizeof(int));
    memset(order, 0, 9*sizeof(int));
    memset(status, 0, 9*sizeof(int));
    
    for (i=1; i<=8; i++) {
        for (j=0; j<constraints; j++) {
            if (con[j][0]==i) {
                c[i]++;
            }
        }
        for (j=0; j<constraints; j++) {
            if (con[j][1]==i) {
                c[i]++;
            }
        }
    }
    
    for (j=1; j<=8; j++) {
        if (c[j]<2) {
            order[1]=j;
            status[j]=1;
            break;
        }
    }
    
    for (i=1; i<=7; i++) {
        if (c[order[i]]>0) {
            for (j=0; j<constraints; j++) {
                if (con[j][0]==order[i]) {
                    if (status[con[j][1]]==0) {
                        order[i+1]=con[j][1];
                        status[con[j][1]]=1;
                        c[con[j][1]]--;
                        break;
                    }
                }
            }
            for (j=0; j<constraints; j++) {
                if (con[j][1]==order[i]) {
                    if (status[con[j][0]]==0) {
                        order[i+1]=con[j][0];
                        status[con[j][0]]=1;
                        c[con[j][0]]--;
                        break;
                    }
                }
            }
        }else if (c[order[i]]==0){
            for (j=1; j<=8; j++) {
                if (c[j]<2 && status[j]==0) {
                    order[i+1]=j;
                    status[j]=1;
                    break;
                }
            }
        }
    }
    
    for (i=1; i<=8; i++) {
        if (order[i]==1) {
            fprintf(fout, "Beatrice\n");
        }else if (order[i]==2){
            fprintf(fout, "Belinda\n");
        }else if (order[i]==3){
            fprintf(fout, "Bella\n");
        }else if (order[i]==4){
            fprintf(fout, "Bessie\n");
        }else if (order[i]==5){
            fprintf(fout, "Betsy\n");
        }else if (order[i]==6){
            fprintf(fout, "Blue\n");
        }else if (order[i]==7){
            fprintf(fout, "Buttercup\n");
        }else if (order[i]==8){
            fprintf(fout, "Sue\n");
        }
    }
    
    
    fclose(fin);
    fclose(fout);
    return 0;
}
