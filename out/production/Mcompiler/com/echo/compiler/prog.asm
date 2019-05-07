		global	main

		extern	malloc

		section	.bss
Static_Data_a_1:	resq	1
Static_Data_str_1:	resq	1

		section	.data
Static_Data_static_str_1:
		dq		4
		db		115, 116, 114, 50, 0
Static_Data_static_str_2:
		dq		4
		db		115, 116, 114, 51, 0
Static_Data_static_str_3:
		dq		4
		db		115, 116, 114, 52, 0
Static_Data_static_str_4:
		dq		4
		db		115, 116, 114, 53, 0
Static_Data_static_str_5:
		dq		4
		db		115, 116, 114, 54, 0
Static_Data_static_str_6:
		dq		4
		db		115, 116, 114, 55, 0
Static_Data_static_str_7:
		dq		4
		db		115, 116, 114, 56, 0
Static_Data_static_str_8:
		dq		4
		db		115, 116, 114, 57, 0
Static_Data_static_str_9:
		dq		5
		db		115, 116, 114, 49, 48, 0
Static_Data_static_str_10:
		dq		4
		db		115, 116, 114, 49, 0

		section	.text

# function main

main:
		push	rbx
		push	rbp
		sub		rsp, 184
		mov		rbp, rsp
		mov		r9, qword [Static_Data_str_1]
		mov		qword [rbp], r9
		mov		r9, qword [Static_Data_a_1]
		mov		qword [rbp+8], r9
		push	r9
		push	r10
		call	Block_init_func_start_1
		pop		r10
		pop		r9
		mov		r9, qword [Static_Data_a_1]
		mov		qword [rbp+8], r9
		mov		r9, qword [Static_Data_str_1]
		mov		qword [rbp], r9
		mov		r9, 0
		mov		qword [rbp+16], r9
		mov		r9, 0
		mov		qword [rbp+24], r9
		mov		r9, 0
		mov		qword [rbp+16], r9

Block_for_cond_1:
		mov		r9, qword [rbp+16]
		and		r9, -1
		xor		rax, rax
		cmp		r9, 29
		setle	al
		mov		r10, rax
		mov		qword [rbp+32], r10
		mov		r9, qword [rbp+32]
		cmp		r9, 1
		je		Block_for_body_1

Block_for_after_1:
		mov		rax, 0
		add		rsp, 184
		pop		rbp
		pop		rbx
		ret

Block_for_body_1:
		mov		r9, 0
		mov		qword [rbp+40], r9
		mov		r9, qword [rbp+16]
		mov		r10, r9
		mov		qword [rbp+48], r10
		mov		r9, qword [rbp+48]
		imul		r9, 8
		mov		qword [rbp+48], r9
		mov		r9, qword [rbp+48]
		mov		r10, qword [rbp]
		add		r9, r10
		mov		qword [rbp+48], r9
		mov		r9, qword [rbp+16]
		mov		r10, r9
		mov		qword [rbp+56], r10
		mov		r9, qword [rbp+56]
		imul		r9, 8
		mov		qword [rbp+56], r9
		mov		r9, qword [rbp+56]
		mov		r10, qword [rbp+8]
		add		r9, r10
		mov		qword [rbp+56], r9
		mov		r9, qword [rbp+56]
		mov		r10, qword [r9+8]
		mov		qword [rbp+56], r10
		mov		r9, 0
		mov		qword [rbp+64], r9
		mov		r9, qword [rbp+64]
		imul		r9, 8
		mov		qword [rbp+64], r9
		mov		r9, qword [rbp+64]
		mov		r10, qword [rbp+56]
		add		r9, r10
		mov		qword [rbp+64], r9
		mov		r9, qword [rbp+64]
		mov		r10, qword [r9+8]
		mov		qword [rbp+64], r10
		push	r11
		push	r9
		push	r10
		push	0
		mov		rax, qword [rbp+64]
		mov		rdi, rax
		call	_toString
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		mov		r9, rax
		mov		qword [rbp+72], r9
		mov		r9, qword [rbp+48]
		mov		r10, qword [rbp+72]
		mov		qword [r9+8], r10
		mov		r9, 0
		mov		qword [rbp+24], r9

Block_for_cond_2:
		mov		r9, qword [rbp+24]
		mov		r10, qword [rbp+16]
		and		r9, -1
		and		r10, -1
		xor		rax, rax
		cmp		r9, r10
		setl	al
		mov		r11, rax
		mov		qword [rbp+80], r11
		mov		r9, qword [rbp+80]
		cmp		r9, 1
		je		Block_for_body_2
		jmp		Block_for_after_2

Block_for_body_2:
		mov		r9, qword [rbp+24]
		mov		r10, r9
		mov		qword [rbp+88], r10
		mov		r9, qword [rbp+88]
		and		r9, 1
		mov		qword [rbp+88], r9
		mov		r9, qword [rbp+88]
		and		r9, -1
		xor		rax, rax
		cmp		r9, 0
		sete	al
		mov		r10, rax
		mov		qword [rbp+96], r10
		mov		r9, qword [rbp+96]
		cmp		r9, 1
		je		Block_if_then_1
		jmp		Block_if_after_1

Block_if_then_1:
		mov		r9, qword [rbp+16]
		mov		r10, r9
		mov		qword [rbp+104], r10
		mov		r9, qword [rbp+104]
		imul		r9, 8
		mov		qword [rbp+104], r9
		mov		r9, qword [rbp+104]
		mov		r10, qword [rbp+8]
		add		r9, r10
		mov		qword [rbp+104], r9
		mov		r9, qword [rbp+104]
		mov		r10, qword [r9+8]
		mov		qword [rbp+104], r10
		mov		r9, 0
		mov		qword [rbp+112], r9
		mov		r9, qword [rbp+112]
		imul		r9, 8
		mov		qword [rbp+112], r9
		mov		r9, qword [rbp+112]
		mov		r10, qword [rbp+104]
		add		r9, r10
		mov		qword [rbp+112], r9
		mov		r9, qword [rbp+112]
		mov		r10, qword [r9+8]
		mov		qword [rbp+112], r10
		mov		r9, qword [rbp+40]
		mov		r10, r9
		mov		qword [rbp+120], r10
		mov		r9, qword [rbp+120]
		mov		r10, qword [rbp+112]
		add		r9, r10
		mov		qword [rbp+120], r9
		mov		r9, qword [rbp+120]
		mov		r10, r9
		mov		qword [rbp+40], r10

Block_if_after_1:
		mov		r9, qword [rbp+24]
		mov		r10, r9
		mov		qword [rbp+128], r10
		mov		r9, qword [rbp+128]
		and		r9, 1
		mov		qword [rbp+128], r9
		mov		r9, qword [rbp+128]
		and		r9, -1
		xor		rax, rax
		cmp		r9, 1
		sete	al
		mov		r10, rax
		mov		qword [rbp+136], r10
		mov		r9, qword [rbp+136]
		cmp		r9, 1
		je		Block_if_then_2
		jmp		Block_if_after_2

Block_if_then_2:
		mov		r9, qword [rbp+16]
		mov		r10, r9
		mov		qword [rbp+144], r10
		mov		r9, qword [rbp+144]
		imul		r9, 8
		mov		qword [rbp+144], r9
		mov		r9, qword [rbp+144]
		mov		r10, qword [rbp+8]
		add		r9, r10
		mov		qword [rbp+144], r9
		mov		r9, qword [rbp+144]
		mov		r10, qword [r9+8]
		mov		qword [rbp+144], r10
		mov		r9, 29
		mov		qword [rbp+152], r9
		mov		r9, qword [rbp+152]
		imul		r9, 8
		mov		qword [rbp+152], r9
		mov		r9, qword [rbp+152]
		mov		r10, qword [rbp+144]
		add		r9, r10
		mov		qword [rbp+152], r9
		mov		r9, qword [rbp+152]
		mov		r10, qword [r9+8]
		mov		qword [rbp+152], r10
		mov		r9, qword [rbp+40]
		mov		r10, r9
		mov		qword [rbp+160], r10
		mov		r9, qword [rbp+160]
		mov		r10, qword [rbp+152]
		add		r9, r10
		mov		qword [rbp+160], r9
		mov		r9, qword [rbp+160]
		mov		r10, r9
		mov		qword [rbp+40], r10

Block_if_after_2:

Block_for_step_1:
		mov		r9, qword [rbp+24]
		mov		r10, r9
		mov		qword [rbp+168], r10
		mov		r9, qword [rbp+24]
		inc		r9
		mov		qword [rbp+24], r9
		jmp		Block_for_cond_2

Block_for_after_2:
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_10
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_1
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_2
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_3
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_4
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_5
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_6
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_7
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_8
		call	_print
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11
		push	r11
		push	r9
		push	r10
		push	0
		mov		rdi, Static_Data_static_str_9
		call	_println
		add		rsp, 8
		pop		r10
		pop		r9
		pop		r11

Block_for_step_2:
		mov		r9, qword [rbp+16]
		mov		r10, r9
		mov		qword [rbp+176], r10
		mov		r9, qword [rbp+16]
		inc		r9
		mov		qword [rbp+16], r9
		jmp		Block_for_cond_1

# function init_func

Block_init_func_start_1:
		push	rbx
		push	rbp
		sub		rsp, 88
		mov		rbp, rsp
		mov		r9, qword [Static_Data_str_1]
		mov		qword [rbp], r9
		mov		r9, qword [Static_Data_a_1]
		mov		qword [rbp+8], r9
		mov		r9, 30
		mov		qword [rbp+16], r9
		mov		r9, qword [rbp+16]
		imul		r9, 8
		mov		qword [rbp+16], r9
		mov		r9, qword [rbp+16]
		add		r9, 8
		mov		qword [rbp+16], r9
		mov		r9, qword [rbp+16]
		push	r9
		push	r10
		mov		rdi, r9
		call	malloc
		pop		r10
		pop		r9
		mov		r10, rax
		mov		qword [rbp+16], r10
		mov		r9, qword [rbp+16]
		mov		qword [r9], 30
		mov		r9, 0
		mov		qword [rbp+24], r9
		mov		r9, qword [rbp+16]
		mov		r10, r9
		mov		qword [rbp+32], r10

Block_while_cond_1:
		mov		r9, qword [rbp+24]
		and		r9, -1
		xor		rax, rax
		cmp		r9, 30
		setl	al
		mov		r10, rax
		mov		qword [rbp+40], r10
		mov		r9, qword [rbp+40]
		cmp		r9, 1
		je		Block_while_body_1

Block_while_after_1:
		mov		r9, qword [rbp+16]
		mov		r10, r9
		mov		qword [rbp+48], r10
		mov		r9, qword [rbp+48]
		mov		r10, r9
		mov		qword [rbp+8], r10
		mov		r9, 30
		mov		qword [rbp+56], r9
		mov		r9, qword [rbp+56]
		imul		r9, 8
		mov		qword [rbp+56], r9
		mov		r9, qword [rbp+56]
		add		r9, 8
		mov		qword [rbp+56], r9
		mov		r9, qword [rbp+56]
		push	r9
		push	r10
		mov		rdi, r9
		call	malloc
		pop		r10
		pop		r9
		mov		r10, rax
		mov		qword [rbp+56], r10
		mov		r9, qword [rbp+56]
		mov		qword [r9], 30
		mov		r9, qword [rbp+56]
		mov		r10, r9
		mov		qword [rbp+64], r10
		mov		r9, qword [rbp+64]
		mov		r10, r9
		mov		qword [rbp], r10
		mov		r9, qword [rbp]
		mov		qword [Static_Data_str_1], r9
		mov		r9, qword [rbp+8]
		mov		qword [Static_Data_a_1], r9
		add		rsp, 88
		pop		rbp
		pop		rbx
		ret

Block_while_body_1:
		mov		r9, qword [rbp+32]
		add		r9, 8
		mov		qword [rbp+32], r9
		mov		r9, 30
		mov		qword [rbp+72], r9
		mov		r9, qword [rbp+72]
		imul		r9, 8
		mov		qword [rbp+72], r9
		mov		r9, qword [rbp+72]
		add		r9, 8
		mov		qword [rbp+72], r9
		mov		r9, qword [rbp+72]
		push	r9
		push	r10
		mov		rdi, r9
		call	malloc
		pop		r10
		pop		r9
		mov		r10, rax
		mov		qword [rbp+72], r10
		mov		r9, qword [rbp+72]
		mov		qword [r9], 30
		mov		r9, qword [rbp+32]
		mov		r10, qword [rbp+72]
		mov		qword [r9], r10
		mov		r9, qword [rbp+24]
		inc		r9
		mov		qword [rbp+24], r9
		jmp		Block_while_cond_1


# built-in functions

default rel

global _builtin_string_concat
global _builtin_string_equal
global _builtin_string_not_equal
global _builtin_string_less
global _builtin_string_less_equal
global _print
global _println
global _printInt
global _printlnInt
global _getString
global _getInt
global _toString
global _member_string_substring
global _member_string_parseInt
global _member_string_ord

extern getchar
extern strlen
extern scanf
extern __stack_chk_fail
extern putchar
extern puts
extern printf
extern strcmp
extern malloc


SECTION .text   

_builtin_string_concat:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     rax, qword [rbp-28H]
        mov     rax, qword [rax]
        mov     dword [rbp-10H], eax
        mov     rax, qword [rbp-30H]
        mov     rax, qword [rax]
        mov     dword [rbp-0CH], eax
        mov     eax, dword [rbp-10H]
        lea     edx, [rax+9H]
        mov     eax, dword [rbp-0CH]
        add     eax, edx
        cdqe
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     edx, dword [rbp-10H]
        mov     eax, dword [rbp-0CH]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        mov     qword [rax], rdx
        add     qword [rbp-28H], 8
        add     qword [rbp-30H], 8
        add     qword [rbp-8H], 8
        mov     dword [rbp-1CH], -1
        mov     dword [rbp-18H], 0
L_001:  mov     eax, dword [rbp-18H]
        cmp     eax, dword [rbp-10H]
        jge     L_002
        add     dword [rbp-1CH], 1
        mov     eax, dword [rbp-1CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     eax, dword [rbp-18H]
        movsxd  rcx, eax
        mov     rax, qword [rbp-28H]
        add     rax, rcx
        movzx   eax, byte [rax]
        mov     byte [rdx], al
        add     dword [rbp-18H], 1
        jmp     L_001

L_002:  mov     dword [rbp-14H], 0
L_003:  mov     eax, dword [rbp-14H]
        cmp     eax, dword [rbp-0CH]
        jge     L_004
        add     dword [rbp-1CH], 1
        mov     eax, dword [rbp-1CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     eax, dword [rbp-14H]
        movsxd  rcx, eax
        mov     rax, qword [rbp-30H]
        add     rax, rcx
        movzx   eax, byte [rax]
        mov     byte [rdx], al
        add     dword [rbp-14H], 1
        jmp     L_003

L_004:  mov     eax, dword [rbp-1CH]
        cdqe
        lea     rdx, [rax+1H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        sub     rax, 8
        leave
        ret


_builtin_string_equal:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        sete    al
        movzx   eax, al
        leave
        ret


_builtin_string_not_equal:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setne   al
        movzx   eax, al
        leave
        ret


_builtin_string_less:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        shr     eax, 31
        movzx   eax, al
        leave
        ret


_builtin_string_less_equal:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setle   al
        movzx   eax, al
        leave
        ret


_print:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rax
        mov     edi, L_043
        mov     eax, 0
        call    printf
        nop
        leave
        ret


_println:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rdi, rax
        call    puts
        nop
        leave
        ret


_printInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 80
        mov     dword [rbp-44H], edi


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        cmp     dword [rbp-44H], 0
        jnz     L_005
        mov     edi, 48
        call    putchar
L_005:  cmp     dword [rbp-44H], 0
        jns     L_006
        neg     dword [rbp-44H]
        mov     edi, 45
        call    putchar
L_006:  mov     dword [rbp-38H], 0
L_007:  cmp     dword [rbp-44H], 0
        jle     L_008
        mov     esi, dword [rbp-38H]
        lea     eax, [rsi+1H]
        mov     dword [rbp-38H], eax
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        sub     ecx, eax
        mov     edx, ecx
        movsxd  rax, esi
        mov     dword [rbp+rax*4-30H], edx
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        mov     dword [rbp-44H], eax
        jmp     L_007

L_008:  mov     eax, dword [rbp-38H]
        sub     eax, 1
        mov     dword [rbp-34H], eax
L_009:  cmp     dword [rbp-34H], 0
        js      L_010
        mov     eax, dword [rbp-34H]
        cdqe
        mov     eax, dword [rbp+rax*4-30H]
        add     eax, 48
        mov     edi, eax
        call    putchar
        sub     dword [rbp-34H], 1
        jmp     L_009

L_010:  nop
        mov     rax, qword [rbp-8H]


        xor     rax, qword [fs:abs 28H]
        jz      L_011
        call    __stack_chk_fail
L_011:  leave
        ret


_printlnInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 80
        mov     dword [rbp-44H], edi


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        cmp     dword [rbp-44H], 0
        jnz     L_012
        mov     edi, 48
        call    putchar
L_012:  cmp     dword [rbp-44H], 0
        jns     L_013
        neg     dword [rbp-44H]
        mov     edi, 45
        call    putchar
L_013:  mov     dword [rbp-38H], 0
L_014:  cmp     dword [rbp-44H], 0
        jle     L_015
        mov     esi, dword [rbp-38H]
        lea     eax, [rsi+1H]
        mov     dword [rbp-38H], eax
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        sub     ecx, eax
        mov     edx, ecx
        movsxd  rax, esi
        mov     dword [rbp+rax*4-30H], edx
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        mov     dword [rbp-44H], eax
        jmp     L_014

L_015:  mov     eax, dword [rbp-38H]
        sub     eax, 1
        mov     dword [rbp-34H], eax
L_016:  cmp     dword [rbp-34H], 0
        js      L_017
        mov     eax, dword [rbp-34H]
        cdqe
        mov     eax, dword [rbp+rax*4-30H]
        add     eax, 48
        mov     edi, eax
        call    putchar
        sub     dword [rbp-34H], 1
        jmp     L_016

L_017:  mov     edi, 10
        call    putchar
        nop
        mov     rax, qword [rbp-8H]


        xor     rax, qword [fs:abs 28H]
        jz      L_018
        call    __stack_chk_fail
L_018:  leave
        ret


_getString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     edi, 266
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rax
        mov     edi, L_043
        mov     eax, 0
        call    scanf
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rdi, rax
        call    strlen
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        mov     qword [rax], rdx
        mov     rax, qword [rbp-8H]
        leave
        ret


_getInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        call    getchar
        mov     byte [rbp-6H], al
        mov     byte [rbp-5H], 0
L_019:  cmp     byte [rbp-6H], 47
        jle     L_020
        cmp     byte [rbp-6H], 57
        jle     L_022
L_020:  cmp     byte [rbp-6H], 45
        jnz     L_021
        mov     byte [rbp-5H], 1
L_021:  call    getchar
        mov     byte [rbp-6H], al
        jmp     L_019

L_022:  movsx   eax, byte [rbp-6H]
        sub     eax, 48
        mov     dword [rbp-4H], eax
        call    getchar
        mov     byte [rbp-6H], al
L_023:  cmp     byte [rbp-6H], 47
        jle     L_024
        cmp     byte [rbp-6H], 57
        jg      L_024
        mov     edx, dword [rbp-4H]
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        mov     edx, eax
        movsx   eax, byte [rbp-6H]
        add     eax, edx
        sub     eax, 48
        mov     dword [rbp-4H], eax
        call    getchar
        mov     byte [rbp-6H], al
        jmp     L_023

L_024:  cmp     byte [rbp-5H], 0
        jz      L_025
        mov     eax, dword [rbp-4H]
        neg     eax
        jmp     L_026

L_025:  mov     eax, dword [rbp-4H]
L_026:  leave
        ret


_toString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 96
        mov     dword [rbp-54H], edi


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        mov     dword [rbp-44H], 0
        mov     dword [rbp-40H], 0
        cmp     dword [rbp-54H], 0
        jns     L_027
        mov     dword [rbp-44H], 1
        neg     dword [rbp-54H]
L_027:  cmp     dword [rbp-54H], 0
        jnz     L_028
        add     dword [rbp-40H], 1
        mov     eax, dword [rbp-40H]
        cdqe
        mov     dword [rbp+rax*4-30H], 0
        jmp     L_029

L_028:  cmp     dword [rbp-54H], 0
        jz      L_029
        add     dword [rbp-40H], 1
        mov     ecx, dword [rbp-54H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        sub     ecx, eax
        mov     edx, ecx
        mov     eax, dword [rbp-40H]
        cdqe
        mov     dword [rbp+rax*4-30H], edx
        mov     ecx, dword [rbp-54H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        mov     dword [rbp-54H], eax
        jmp     L_028

L_029:  mov     edx, dword [rbp-40H]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        add     eax, 9
        cdqe
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-38H], rax
        mov     edx, dword [rbp-40H]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-38H]
        mov     qword [rax], rdx
        add     qword [rbp-38H], 8
        mov     edx, dword [rbp-40H]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-38H]
        add     rax, rdx
        mov     byte [rax], 0
        cmp     dword [rbp-44H], 0
        jz      L_030
        mov     rax, qword [rbp-38H]
        mov     byte [rax], 45
L_030:  mov     dword [rbp-3CH], 0
L_031:  mov     eax, dword [rbp-3CH]
        cmp     eax, dword [rbp-40H]
        jge     L_032
        mov     edx, dword [rbp-3CH]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-38H]
        add     rdx, rax
        mov     eax, dword [rbp-40H]
        sub     eax, dword [rbp-3CH]
        cdqe
        mov     eax, dword [rbp+rax*4-30H]
        add     eax, 48
        mov     byte [rdx], al
        add     dword [rbp-3CH], 1
        jmp     L_031

L_032:  mov     rax, qword [rbp-38H]
        sub     rax, 8
        mov     rsi, qword [rbp-8H]


        xor     rsi, qword [fs:abs 28H]
        jz      L_033
        call    __stack_chk_fail
L_033:  leave
        ret


_member_string_substring:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     qword [rbp-18H], rdi
        mov     dword [rbp-1CH], esi
        mov     dword [rbp-20H], edx
        mov     eax, dword [rbp-20H]
        sub     eax, dword [rbp-1CH]
        add     eax, 1
        mov     dword [rbp-0CH], eax
        mov     eax, dword [rbp-0CH]
        add     eax, 9
        cdqe
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        mov     qword [rax], rdx
        mov     eax, dword [rbp-1CH]
        cdqe
        add     rax, 8
        add     qword [rbp-18H], rax
        add     qword [rbp-8H], 8
        mov     dword [rbp-10H], 0
L_034:  mov     eax, dword [rbp-10H]
        cmp     eax, dword [rbp-0CH]
        jge     L_035
        mov     eax, dword [rbp-10H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     eax, dword [rbp-10H]
        movsxd  rcx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rcx
        movzx   eax, byte [rax]
        mov     byte [rdx], al
        add     dword [rbp-10H], 1
        jmp     L_034

L_035:  mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        sub     rax, 8
        leave
        ret


_member_string_parseInt:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-18H], rdi
        add     qword [rbp-18H], 8
        mov     byte [rbp-9H], 0
        mov     dword [rbp-8H], 0
L_036:  mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 47
        jle     L_037
        mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 57
        jle     L_038
L_037:  mov     eax, dword [rbp-8H]
        lea     edx, [rax+1H]
        mov     dword [rbp-8H], edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 45
        sete    al
        test    al, al
        jz      L_036
        mov     byte [rbp-9H], 1
        jmp     L_036

L_038:  mov     eax, dword [rbp-8H]
        lea     edx, [rax+1H]
        mov     dword [rbp-8H], edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   eax, al
        sub     eax, 48
        mov     dword [rbp-4H], eax
L_039:  mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 47
        jle     L_040
        mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 57
        jg      L_040
        mov     edx, dword [rbp-4H]
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        mov     ecx, eax
        mov     eax, dword [rbp-8H]
        lea     edx, [rax+1H]
        mov     dword [rbp-8H], edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   eax, al
        add     eax, ecx
        sub     eax, 48
        mov     dword [rbp-4H], eax
        jmp     L_039

L_040:  cmp     byte [rbp-9H], 0
        jz      L_041
        mov     eax, dword [rbp-4H]
        neg     eax
        jmp     L_042

L_041:  mov     eax, dword [rbp-4H]
L_042:  pop     rbp
        ret


_member_string_ord:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     dword [rbp-0CH], esi
        add     dword [rbp-0CH], 8
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   eax, al
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_043:
        db 25H, 73H, 00H


