//
/*
ID: 77617781
LANG: C
TASK: namenum
*/

#include <stdio.h>
#include <string.h>
long long turnint(FILE *names, char nam[]);

int main(int argc, const char * argv[]) {
    FILE *fin, *fout, *names;
    fin = fopen("namenum.in", "r");
    fout = fopen("namenum.out", "w");
    names = fopen("dict.txt", "r");
    
    long long serial = 0;
    int i = 0;
    char nam[13] = {""};
    fscanf(fin, "%lld", &serial);
    long long a = 0;
    int s = 0;
    while (1) {
        fscanf(names, "%s", nam);
        a = turnint(names, nam);
        
        
        if (serial == a) {
            s = 1;
            fprintf(fout, "%s\n", nam);
        }else if (feof(names)){
            if (s == 0) {
                fprintf(fout, "NONE\n");
            }
            break;
        }
        i++;
    }
    
    fclose(fin);
    fclose(fout);
    fclose(names);
    return 0;
}
long long turnint(FILE *names, char nam[]){
    long long ret = 0;
    int i = 0;
    
    while (1) {
        if (nam[i]=='A'||nam[i]=='B'||nam[i]=='C') {
            ret=10*ret+2;
        }else if (nam[i]=='D'||nam[i]=='E'||nam[i]=='F'){
            ret=10*ret+3;
        }else if (nam[i]=='G'||nam[i]=='H'||nam[i]=='I'){
            ret=10*ret+4;
        }else if (nam[i]=='J'||nam[i]=='K'||nam[i]=='L'){
            ret=10*ret+5;
        }else if (nam[i]=='M'||nam[i]=='N'||nam[i]=='O'){
            ret=10*ret+6;
        }else if (nam[i]=='P'||nam[i]=='R'||nam[i]=='S'){
            ret=10*ret+7;
        }else if (nam[i]=='T'||nam[i]=='U'||nam[i]=='V'){
            ret=10*ret+8;
        }else if (nam[i]=='W'||nam[i]=='X'||nam[i]=='Y'){
            ret=10*ret+9;
        }else if (nam[i]=='Q'||nam[i]=='Z'){
            ret=10*ret+1;
        }else{
            return ret;
        }
        i++;
    }
    return ret;
}
