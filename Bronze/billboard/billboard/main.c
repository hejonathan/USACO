//
/*
ID: 77617781
LANG: C
TASK: billboard
*/

#include <stdio.h>
int measure(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2);

int main(int argc, const char * argv[]) {
    FILE *fin = fopen("billboard.in", "r");
    FILE *fout = fopen("billboard.out", "w");
    int x1[2]={0}, y1[2]={0}, x2[2]={0}, y2[2]={0};
    int area[2] = {0};
    int a1, b1, a2, b2;
    
    fscanf(fin, "%d %d %d %d", &x1[0], &y1[0], &x2[0], &y2[0]);
    fscanf(fin, "%d %d %d %d", &x1[1], &y1[1], &x2[1], &y2[1]);
    fscanf(fin, "%d %d %d %d", &a1, &b1, &a2, &b2);
    
    area[0] = (y2[0]-y1[0])*(x2[0]-x1[0])-measure(x1[0], y1[0], x2[0], y2[0], a1, b1, a2, b2);
    area[1] = (y2[1]-y1[1])*(x2[1]-x1[1])-measure(x1[1], y1[1], x2[1], y2[1], a1, b1, a2, b2);
    
    fprintf(fout, "%d\n", area[0]+area[1]);
    
    fclose(fin);
    fclose(fout);
    return 0;
}
int measure(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2){
    int blocked = 0;
    int height = 0;
    int width = 0;
    
    if (x1<=a1 && a1<=x2) {
        if (a2<x2) {
            width = a2 - a1;
        }else{
            width = x2 - a1;
        }
    }else if (a1<x1){
        if (a2<x1) {
            width = 0;
        }else if(a2<x2){
            width = a2 - x1;
        }else{
            width = x2 - x1;
        }
    }else{
        width = 0;
    }
    
    if (y1<=b1 && b1<=y2) {
        if (b2<y2) {
            height = b2 - b1;
        }else{
            height = y2 - b1;
        }
    }else if (b1<y1){
        if (b2<y1) {
            height = 0;
        }else if(b2<y2){
            height = b2 - y1;
        }else{
            height = y2 - y1;
        }
    }else{
        height = 0;
    }
    blocked = height * width;
    return blocked;
}
