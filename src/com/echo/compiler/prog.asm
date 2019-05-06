		global	main

		extern	malloc

		section	.bss
Static_Data_a_1:	resq	1
Static_Data_n_1:	resq	1

		section	.data
Static_Data_static_str_1:
		dq		3
		db		34, 32, 34, 0
Static_Data_static_str_2:
		dq		3
		db		34, 10, 34, 0

		section	.text

# function qsrt

Block_qsrt_start_1:
		push	r12
		push	rbx
		sub		rsp, 216
		mov		rbp, rsp
		mov		r10, qword [Static_Data_a_1]
		mov		qword [rbp], r10
		mov		r10, rdi
		mov		qword [rbp+8], r10
		mov		r10, rsi
		mov		qword [rbp+16], r10
		mov		r10, rdi
		mov		qword [rbp+24], r10
		mov		r10, qword [rbp+24]
		add		r10, rsi
		mov		qword [rbp+24], r10
		mov		r10, qword [rbp+24]
		mov		rbx, 2
		mov		rax, r10
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r11, rax
		mov		rdx, r8
		mov		qword [rbp+32], r11
		mov		r10, qword [rbp+32]
		mov		r11, r10
		mov		qword [rbp+40], r11
		mov		r10, qword [rbp+40]
		imul		r10, 8
		mov		qword [rbp+40], r10
		mov		r10, qword [rbp+40]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+40], r10
		mov		r10, qword [rbp+40]
		mov		r11, qword [r10+8]
		mov		qword [rbp+40], r11
		mov		r10, qword [rbp+40]
		mov		r11, r10
		mov		qword [rbp+48], r11

Block_while_cond_1:
		mov		r10, qword [rbp+8]
		mov		r11, qword [rbp+16]
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setle	al
		mov		r12, rax
		mov		qword [rbp+56], r12
		mov		r10, qword [rbp+56]
		cmp		r10, 1
		je		Block_while_body_1

Block_while_after_1:
		mov		r10, qword [rbp+16]
		and		rdi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rdi, r10
		setl	al
		mov		r11, rax
		mov		qword [rbp+64], r11
		mov		r10, qword [rbp+64]
		cmp		r10, 1
		je		Block_if_then_1
		jmp		Block_if_after_1

Block_if_then_1:
		mov		r10, qword [rbp+16]
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdi
		mov		rdi, qword [rsp]
		mov		rsi, r10
		add		rsp, 8
		call	Block_qsrt_start_1
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r11, rax
		mov		qword [rbp+72], r11

Block_if_after_1:
		mov		r10, qword [rbp+8]
		and		r10, -1
		and		rsi, -1
		xor		rax, rax
		cmp		r10, rsi
		setl	al
		mov		r11, rax
		mov		qword [rbp+80], r11
		mov		r10, qword [rbp+80]
		cmp		r10, 1
		je		Block_if_then_2
		jmp		Block_if_after_2

Block_if_then_2:
		mov		r10, qword [rbp+8]
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rsi
		mov		rdi, r10
		mov		rsi, qword [rsp]
		add		rsp, 8
		call	Block_qsrt_start_1
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r11, rax
		mov		qword [rbp+88], r11

Block_if_after_2:
		mov		rax, 0
		add		rsp, 216
		pop		rbx
		pop		r12
		ret

Block_while_body_1:

Block_while_cond_2:
		mov		r10, qword [rbp+8]
		mov		r11, r10
		mov		qword [rbp+96], r11
		mov		r10, qword [rbp+96]
		imul		r10, 8
		mov		qword [rbp+96], r10
		mov		r10, qword [rbp+96]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+96], r10
		mov		r10, qword [rbp+96]
		mov		r11, qword [r10+8]
		mov		qword [rbp+96], r11
		mov		r10, qword [rbp+96]
		mov		r11, qword [rbp+48]
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setl	al
		mov		r12, rax
		mov		qword [rbp+104], r12
		mov		r10, qword [rbp+104]
		cmp		r10, 1
		je		Block_while_body_2

Block_while_after_2:

Block_while_cond_3:
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+112], r11
		mov		r10, qword [rbp+112]
		imul		r10, 8
		mov		qword [rbp+112], r10
		mov		r10, qword [rbp+112]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+112], r10
		mov		r10, qword [rbp+112]
		mov		r11, qword [r10+8]
		mov		qword [rbp+112], r11
		mov		r10, qword [rbp+112]
		mov		r11, qword [rbp+48]
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setg	al
		mov		r12, rax
		mov		qword [rbp+120], r12
		mov		r10, qword [rbp+120]
		cmp		r10, 1
		je		Block_while_body_3
		jmp		Block_while_after_3

Block_while_body_3:
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+128], r11
		mov		r10, qword [rbp+16]
		dec		r10
		mov		qword [rbp+16], r10
		jmp		Block_while_cond_3

Block_while_after_3:
		mov		r10, qword [rbp+8]
		mov		r11, qword [rbp+16]
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setle	al
		mov		r12, rax
		mov		qword [rbp+136], r12
		mov		r10, qword [rbp+136]
		cmp		r10, 1
		je		Block_if_then_3
		jmp		Block_if_after_3

Block_if_then_3:
		mov		r10, qword [rbp+8]
		mov		r11, r10
		mov		qword [rbp+144], r11
		mov		r10, qword [rbp+144]
		imul		r10, 8
		mov		qword [rbp+144], r10
		mov		r10, qword [rbp+144]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+144], r10
		mov		r10, qword [rbp+144]
		mov		r11, qword [r10+8]
		mov		qword [rbp+144], r11
		mov		r10, qword [rbp+144]
		mov		r11, r10
		mov		qword [rbp+152], r11
		mov		r10, qword [rbp+8]
		mov		r11, r10
		mov		qword [rbp+160], r11
		mov		r10, qword [rbp+160]
		imul		r10, 8
		mov		qword [rbp+160], r10
		mov		r10, qword [rbp+160]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+160], r10
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+168], r11
		mov		r10, qword [rbp+168]
		imul		r10, 8
		mov		qword [rbp+168], r10
		mov		r10, qword [rbp+168]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+168], r10
		mov		r10, qword [rbp+168]
		mov		r11, qword [r10+8]
		mov		qword [rbp+168], r11
		mov		r10, qword [rbp+160]
		mov		r11, qword [rbp+168]
		mov		qword [r10+8], r11
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+176], r11
		mov		r10, qword [rbp+176]
		imul		r10, 8
		mov		qword [rbp+176], r10
		mov		r10, qword [rbp+176]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+176], r10
		mov		r10, qword [rbp+176]
		mov		r11, qword [rbp+152]
		mov		qword [r10+8], r11
		mov		r10, qword [rbp+8]
		mov		r11, r10
		mov		qword [rbp+184], r11
		mov		r10, qword [rbp+8]
		inc		r10
		mov		qword [rbp+8], r10
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+192], r11
		mov		r10, qword [rbp+16]
		dec		r10
		mov		qword [rbp+16], r10

Block_if_after_3:
		jmp		Block_while_cond_1

Block_while_body_2:
		mov		r10, qword [rbp+8]
		mov		r11, r10
		mov		qword [rbp+200], r11
		mov		r10, qword [rbp+8]
		inc		r10
		mov		qword [rbp+8], r10
		jmp		Block_while_cond_2

# function main

main:
		push	r12
		push	rbx
		sub		rsp, 104
		mov		rbp, rsp
		mov		r10, qword [Static_Data_a_1]
		mov		qword [rbp], r10
		mov		r10, qword [Static_Data_n_1]
		mov		qword [rbp+8], r10
		push	r11
		push	r10
		call	Block_init_func_start_1
		pop		r10
		pop		r11
		mov		r10, qword [Static_Data_n_1]
		mov		qword [rbp+8], r10
		mov		r10, qword [Static_Data_a_1]
		mov		qword [rbp], r10
		mov		r10, 0
		mov		qword [rbp+16], r10
		mov		r10, 1
		mov		qword [rbp+16], r10

Block_for_cond_1:
		mov		r10, qword [rbp+16]
		mov		r11, qword [rbp+8]
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setle	al
		mov		r12, rax
		mov		qword [rbp+24], r12
		mov		r10, qword [rbp+24]
		cmp		r10, 1
		je		Block_for_body_1

Block_for_after_1:
		mov		r10, qword [rbp+8]
		push	r11
		push	r10
		mov		rdi, 1
		mov		rsi, r10
		call	Block_qsrt_start_1
		pop		r10
		pop		r11
		mov		r11, rax
		mov		qword [rbp+32], r11
		mov		r10, 1
		mov		qword [rbp+16], r10

Block_for_cond_2:
		mov		r10, qword [rbp+16]
		mov		r11, qword [rbp+8]
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setle	al
		mov		r12, rax
		mov		qword [rbp+40], r12
		mov		r10, qword [rbp+40]
		cmp		r10, 1
		je		Block_for_body_2
		jmp		Block_for_after_2

Block_for_body_2:
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+48], r11
		mov		r10, qword [rbp+48]
		imul		r10, 8
		mov		qword [rbp+48], r10
		mov		r10, qword [rbp+48]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+48], r10
		mov		r10, qword [rbp+48]
		mov		r11, qword [r10+8]
		mov		qword [rbp+48], r11
		mov		r10, qword [rbp+48]
		push	r11
		push	r10
		mov		rdi, r10
		call	_printInt
		pop		r10
		pop		r11
		push	r11
		push	r10
		mov		rdi, Static_Data_static_str_1
		call	_print
		pop		r10
		pop		r11

Block_for_step_1:
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+56], r11
		mov		r10, qword [rbp+16]
		inc		r10
		mov		qword [rbp+16], r10
		jmp		Block_for_cond_2

Block_for_after_2:
		push	r11
		push	r10
		mov		rdi, Static_Data_static_str_2
		call	_print
		pop		r10
		pop		r11
		mov		r10, qword [rbp]
		mov		qword [Static_Data_a_1], r10
		mov		r10, qword [rbp+8]
		mov		qword [Static_Data_n_1], r10
		mov		rax, 0
		add		rsp, 104
		pop		rbx
		pop		r12
		ret

Block_for_body_1:
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+64], r11
		mov		r10, qword [rbp+64]
		imul		r10, 8
		mov		qword [rbp+64], r10
		mov		r10, qword [rbp+64]
		mov		r11, qword [rbp]
		add		r10, r11
		mov		qword [rbp+64], r10
		mov		r10, qword [rbp+8]
		mov		r11, r10
		mov		qword [rbp+72], r11
		mov		r10, qword [rbp+72]
		inc		r10
		mov		qword [rbp+72], r10
		mov		r10, qword [rbp+72]
		mov		r11, r10
		mov		qword [rbp+80], r11
		mov		r10, qword [rbp+80]
		mov		r11, qword [rbp+16]
		sub		r10, r11
		mov		qword [rbp+80], r10
		mov		r10, qword [rbp+64]
		mov		r11, qword [rbp+80]
		mov		qword [r10+8], r11

Block_for_step_2:
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+88], r11
		mov		r10, qword [rbp+16]
		inc		r10
		mov		qword [rbp+16], r10
		jmp		Block_for_cond_1

# function init_func

Block_init_func_start_1:
		push	rbx
		sub		rsp, 32
		mov		rbp, rsp
		mov		r10, qword [Static_Data_a_1]
		mov		qword [rbp], r10
		mov		r10, qword [Static_Data_n_1]
		mov		qword [rbp+8], r10
		mov		r10, 10100
		mov		qword [rbp+16], r10
		mov		r10, qword [rbp+16]
		imul		r10, 8
		mov		qword [rbp+16], r10
		mov		r10, qword [rbp+16]
		add		r10, 8
		mov		qword [rbp+16], r10
		mov		r10, qword [rbp+16]
		push	r11
		push	r10
		push	rbp
		mov		rdi, r10
		push	0
		call	malloc
		add		rsp, 8
		pop		rbp
		pop		r10
		pop		r11
		mov		r11, rax
		mov		qword [rbp+16], r11
		mov		r10, qword [rbp+16]
		mov		qword [r10], 10100
		mov		r10, qword [rbp+16]
		mov		r11, r10
		mov		qword [rbp+24], r11
		mov		r10, qword [rbp+24]
		mov		r11, r10
		mov		qword [rbp], r11
		mov		r10, 10000
		mov		qword [rbp+8], r10
		mov		r10, qword [rbp]
		mov		qword [Static_Data_a_1], r10
		mov		r10, qword [rbp+8]
		mov		qword [Static_Data_n_1], r10
		add		rsp, 32
		pop		rbx
		ret


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


