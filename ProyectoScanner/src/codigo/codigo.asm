;Código TASM

.MODEL small

.STACK 200h

.DATA
z DW 1 DUP(0)
t DW 1 DUP(0)
y DW 1 DUP(0)
we DW 1 DUP(0)
x DW 1 DUP(0)
zt DW 1 DUP(0)
yyy DW 1 DUP(0)
p DW 1 DUP(0)
qwqwqw DW 1 DUP(0)
;dataFinal

.CODE
	.STARTUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,42
mov yyy,ax
mov ax,yyy
mov p,ax
mov ax,6
mov qwqwqw,ax
mov ax,23
mov we,ax
mov ax,p
mov zt,ax
label1:
mov ax,2
cmp we,ax
jbe label2
jmp label2
jmp label1
label2:
;codeFinal

	.EXIT

END
