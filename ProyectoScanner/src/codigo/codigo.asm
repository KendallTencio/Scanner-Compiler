;Código TASM

.MODEL small

.STACK 200h

.DATA
a DW 1 DUP(0)
;dataFinal

.CODE
	.STARTUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,3
mov a,ax
;codeFinal

	.EXIT

END
