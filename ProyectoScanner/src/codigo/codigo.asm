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
;dataFinal

.CODE
	.STARTUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,42
mov yyy,ax
mov ax,23
mov we,ax
mov ax,45
mov xx,ax
mov ax,98
mov zt,ax
;codeFinal

	.EXIT

END
