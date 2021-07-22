//
/*
ID: 77617781
LANG: C
TASK: paint
*/

#include <stdio.h>

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("paint.in", "r");
    FILE *fout = fopen("paint.out", "w");
    int a=0, b=0, c=0, d=0;
    int length = 0;
    fscanf(fin, "%d %d", &a, &b);
    fscanf(fin, "%d %d", &c, &d);
    if (c < a) {
        if (d < a) {
            length = (d-c)+(b-a);
        }else if (d < b){
            length = b - c;
        }else{
            length = d - c;
        }
    }else if (c >= a && c <= b){
        if (d < b) {
            length = b - a;
        }else{
            length = d - a;
        }
    }else{
        length = (d-c)+(b-a);
    }
    
    fprintf(fout, "%d\n", length);
    fclose(fin);
    fclose(fout);
    return 0;
}
