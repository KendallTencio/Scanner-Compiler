;Código TASM

.MODEL small

.STACK 200h

.DATA
z DW 1 DUP(0)
t DW 1 DUP(0)
y DW 1 DUP(0)
we DW 1 DUP(0)
zt DW 1 DUP(0)
;dataFinal

.CODE
	.STARTUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,42
mov yyy,ax
mov ax,6
mov qwq,ax
mov ax,23
mov we,ax
;codeFinal

	.EXIT

END
