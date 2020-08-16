;Código TASM

.MODEL small

.STACK 200h

.DATA
varz DW 1 DUP(0)
vart DW 1 DUP(0)
vary DW 1 DUP(0)
vary DW 1 DUP(0)
varz DW 1 DUP(0)
vart DW 1 DUP(0)
vary DW 1 DUP(0)
varwe DW 1 DUP(0)
varzt DW 1 DUP(0)
t1 DW 1 DUP(0)
;dataFinal

.CODE
	.STARTUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,we
sub ax,42
mov t1,ax
mov ax,t1
mov yyy,ax
mov ax,yyy
mov p,ax
mov ax,6
mov qwqwqw,ax
mov ax,23
mov we,ax
mov ax,555
mov xx,ax
mov ax,p
mov zt,ax
;codeFinal

	.EXIT

END
