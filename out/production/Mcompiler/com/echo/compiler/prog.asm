		global	main

		extern	malloc

		section	.bss
Static_Data_MAXN_1:	resq	1
Static_Data_mod_1:	resq	1
Static_Data_a_1:	resq	1
Static_Data_num_1:	resq	1

		section	.text

# function workb

Block_workb_start_1:
		push	r13
		push	r12
		push	rbx
		push	rbp
		sub		rsp, 8
		mov		rbp, rsp
		mov		r11, qword [Static_Data_num_1]
		mov		r12, qword [Static_Data_mod_1]
		mov		r10, 0
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r10, qword [r10]
		and		rdi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rdi, r10
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_and_lhs_true_1
		jmp		Block_if_after_1

Block_and_lhs_true_1:
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r10, qword [r10+8]
		and		rsi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rsi, r10
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_1
		jmp		Block_if_after_1

Block_if_then_1:
		imul		rdx, 8
		add		rdx, r11
		mov		rdx, qword [rdx+8]
		mov		r10, qword [rdx+24]
		jmp		Block_workb_end_1

Block_if_after_1:
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r13, qword [r10]
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r10, qword [r10+8]
		add		r13, r10
		mov		rbx, rcx
		mov		rcx, 1
		sar		r13, cl
		mov		rcx, rbx
		and		r13, -1
		mov		r10, r13
		and		rsi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rsi, r10
		setle	al
		mov		r11, rax
		cmp		r11, 1
		je		Block_if_then_2

Block_if_else_1:
		and		rdi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rdi, r10
		setg	al
		mov		r11, rax
		cmp		r11, 1
		je		Block_if_then_3
		jmp		Block_if_else_2

Block_if_then_3:
		mov		r10, rdx
		imul		r10, 2
		inc		r10
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		push	rsi
		mov		rdi, qword [rsp+8]
		mov		rsi, qword [rsp]
		mov		rdx, r10
		add		rsp, 16
		call	Block_workb_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
		jmp		Block_workb_end_1

Block_if_else_2:
		mov		r11, rdx
		imul		r11, 2
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		mov		rdi, qword [rsp]
		mov		rsi, r10
		mov		rdx, r11
		add		rsp, 8
		call	Block_workb_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r11, rax
		mov		r13, r10
		inc		r13
		mov		r10, rdx
		imul		r10, 2
		inc		r10
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rsi
		mov		rdi, r13
		mov		rsi, qword [rsp]
		mov		rdx, r10
		add		rsp, 8
		call	Block_workb_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
		add		r11, r10
		mov		rbx, r12
		mov		rax, r11
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r10, rdx
		mov		rdx, r8
		jmp		Block_workb_end_1

Block_if_then_2:
		imul		rdx, 2
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		push	rsi
		push	rdx
		mov		rdi, qword [rsp+16]
		mov		rsi, qword [rsp+8]
		mov		rdx, qword [rsp]
		add		rsp, 24
		call	Block_workb_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax

Block_workb_end_1:
		mov		rax, r10
		add		rsp, 8
		pop		rbp
		pop		rbx
		pop		r12
		pop		r13
		ret

# function worka

Block_worka_start_1:
		push	r12
		push	rbx
		push	rbp
		mov		rbp, rsp
		mov		r11, qword [Static_Data_num_1]
		mov		r12, 0
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r10, qword [r10]
		and		rdi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rdi, r10
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_and_lhs_true_2
		jmp		Block_if_after_2

Block_and_lhs_true_2:
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r10, qword [r10+8]
		and		rsi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rsi, r10
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_4
		jmp		Block_if_after_2

Block_if_then_4:
		imul		rdx, 8
		add		rdx, r11
		mov		rdx, qword [rdx+8]
		mov		r10, qword [rdx+16]
		jmp		Block_worka_end_1

Block_if_after_2:
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r12, qword [r10]
		mov		r10, rdx
		imul		r10, 8
		add		r10, r11
		mov		r10, qword [r10+8]
		mov		r11, qword [r10+8]
		mov		r10, r12
		add		r10, r11
		mov		rbx, rcx
		mov		rcx, 1
		sar		r10, cl
		mov		rcx, rbx
		and		r10, -1
		mov		r12, r10
		and		rsi, -1
		and		r12, -1
		xor		rax, rax
		cmp		rsi, r12
		setle	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_5

Block_if_else_3:
		and		rdi, -1
		and		r12, -1
		xor		rax, rax
		cmp		rdi, r12
		setg	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_6
		jmp		Block_if_else_4

Block_if_then_6:
		imul		rdx, 2
		inc		rdx
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		push	rsi
		push	rdx
		mov		rdi, qword [rsp+16]
		mov		rsi, qword [rsp+8]
		mov		rdx, qword [rsp]
		add		rsp, 24
		call	Block_worka_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
		jmp		Block_worka_end_1

Block_if_else_4:
		mov		r10, rdx
		imul		r10, 2
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		mov		rdi, qword [rsp]
		mov		rsi, r12
		mov		rdx, r10
		add		rsp, 8
		call	Block_worka_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
		inc		r12
		imul		rdx, 2
		inc		rdx
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rsi
		push	rdx
		mov		rdi, r12
		mov		rsi, qword [rsp+8]
		mov		rdx, qword [rsp]
		add		rsp, 16
		call	Block_worka_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r11, rax
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setl	al
		mov		r12, rax
		cmp		r12, 1
		je		Block_if_then_7

Block_if_else_5:
		jmp		Block_max_end_1

Block_if_then_7:
		mov		r10, r11

Block_max_end_1:
		jmp		Block_worka_end_1

Block_if_then_5:
		imul		rdx, 2
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		push	rsi
		push	rdx
		mov		rdi, qword [rsp+16]
		mov		rsi, qword [rsp+8]
		mov		rdx, qword [rsp]
		add		rsp, 24
		call	Block_worka_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax

Block_worka_end_1:
		mov		rax, r10
		pop		rbp
		pop		rbx
		pop		r12
		ret

# function buildsum

Block_buildsum_start_1:
		push	r15
		push	r13
		push	r12
		push	r14
		push	rbx
		push	rbp
		sub		rsp, 8
		mov		rbp, rsp
		mov		r14, qword [Static_Data_num_1]
		mov		r13, qword [Static_Data_mod_1]
		mov		r10, qword [Static_Data_a_1]
		mov		r15, 0
		mov		r11, rdx
		imul		r11, 8
		add		r11, r14
		mov		r11, qword [r11+8]
		mov		qword [r11], rdi
		mov		r11, rdx
		imul		r11, 8
		add		r11, r14
		mov		r11, qword [r11+8]
		mov		qword [r11+8], rsi
		and		rdi, -1
		and		rsi, -1
		xor		rax, rax
		cmp		rdi, rsi
		sete	al
		mov		r11, rax
		cmp		r11, 1
		je		Block_if_then_8

Block_if_after_3:
		mov		r15, rdi
		add		r15, rsi
		mov		rbx, rcx
		mov		rcx, 1
		sar		r15, cl
		mov		rcx, rbx
		and		r15, -1
		mov		r12, rdx
		imul		r12, 8
		add		r12, r14
		mov		r12, qword [r12+8]
		mov		r10, rdx
		imul		r10, 2
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		mov		rdi, qword [rsp]
		mov		rsi, r15
		mov		rdx, r10
		add		rsp, 8
		call	Block_buildsum_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
		inc		r15
		mov		r11, rdx
		imul		r11, 2
		inc		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rsi
		mov		rdi, r15
		mov		rsi, qword [rsp]
		mov		rdx, r11
		add		rsp, 8
		call	Block_buildsum_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r11, rax
		add		r10, r11
		mov		rbx, r13
		mov		rax, r10
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r10, rdx
		mov		rdx, r8
		mov		qword [r12+24], r10
		imul		rdx, 8
		add		rdx, r14
		mov		rdx, qword [rdx+8]
		mov		rdi, qword [rdx+24]
		jmp		Block_buildsum_end_1

Block_if_then_8:
		imul		rdx, 8
		add		rdx, r14
		mov		rdx, qword [rdx+8]
		mov		r11, rdi
		imul		r11, 8
		add		r11, r10
		mov		r11, qword [r11+8]
		mov		qword [rdx+24], r11
		imul		rdi, 8
		add		rdi, r10
		mov		rdi, qword [rdi+8]

Block_buildsum_end_1:
		mov		rax, rdi
		add		rsp, 8
		pop		rbp
		pop		rbx
		pop		r14
		pop		r12
		pop		r13
		pop		r15
		ret

# function main

main:
		push	r15
		push	r13
		push	r12
		push	r14
		push	rbx
		push	rbp
		sub		rsp, 40
		mov		rbp, rsp
		mov		r8, 10500
		mov		qword [rbp+16], r8
		mov		r8, qword [rbp+16]
		mov		r10, r8
		imul		r10, 8
		add		r10, 8
		push	r11
		push	r8
		push	r10
		mov		rdi, r10
		push	0
		call	malloc
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r10, rax
		mov		r8, qword [rbp+16]
		mov		qword [r10], r8
		mov		r11, 4
		mov		r8, qword [rbp+16]
		imul		r11, r8
		mov		r15, r11
		imul		r15, 8
		add		r15, 8
		push	r11
		push	r8
		push	r10
		mov		rdi, r15
		push	0
		call	malloc
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r15, rax
		mov		qword [r15], r11

Block_init_func_start_1:
		push	r11
		push	r8
		push	r10
		push	0
		call	_getInt
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r13, rax
		push	r11
		push	r8
		push	r10
		push	0
		call	_getInt
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r14, rax
		mov		r8, 0
		mov		qword [rbp+24], r8
		mov		r8, 0
		mov		qword [rbp+24], r8

Block_for_cond_1:
		mov		r11, 4
		mov		r8, qword [rbp+16]
		imul		r11, r8
		mov		r8, qword [rbp+24]
		and		r8, -1
		and		r11, -1
		xor		rax, rax
		cmp		r8, r11
		setl	al
		mov		r11, rax
		cmp		r11, 1
		je		Block_for_body_1

Block_for_after_1:
		mov		r8, 1
		mov		qword [rbp+24], r8

Block_for_cond_2:
		mov		r8, qword [rbp+24]
		and		r8, -1
		and		r14, -1
		xor		rax, rax
		cmp		r8, r14
		setle	al
		mov		r11, rax
		cmp		r11, 1
		je		Block_for_body_2
		jmp		Block_for_after_2

Block_for_body_2:
		mov		r8, qword [rbp+24]
		mov		r12, r8
		imul		r12, 8
		add		r12, r10
		push	r11
		push	r8
		push	r10
		push	0
		call	_getInt
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r11, rax
		mov		rbx, r13
		mov		rax, r11
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r11, rdx
		mov		rdx, r8
		mov		qword [r12+8], r11

Block_for_step_1:
		mov		r8, qword [rbp+24]
		inc		r8
		mov		qword [rbp+24], r8
		jmp		Block_for_cond_2

Block_for_after_2:
		mov		qword [Static_Data_num_1], r15
		mov		qword [Static_Data_a_1], r10
		push	r11
		push	r10
		mov		rdi, 1
		mov		rsi, r14
		mov		rdx, 1
		call	Block_buildmax_start_1
		pop		r10
		pop		r11
		mov		r11, rax
		mov		qword [Static_Data_num_1], r15
		mov		qword [Static_Data_mod_1], r13
		mov		qword [Static_Data_a_1], r10
		push	r11
		push	r10
		mov		rdi, 1
		mov		rsi, r14
		mov		rdx, 1
		call	Block_buildsum_start_1
		pop		r10
		pop		r11
		mov		r11, rax
		push	r11
		push	r8
		push	r10
		push	0
		call	_getInt
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r14, rax
		mov		r12, 0
		mov		r11, 0

Block_while_cond_1:
		mov		r11, r14
		dec		r14
		and		r11, -1
		xor		rax, rax
		cmp		r11, 0
		setg	al
		mov		r11, rax
		cmp		r11, 1
		je		Block_while_body_1

Block_while_after_1:
		mov		qword [Static_Data_num_1], r15
		mov		qword [Static_Data_mod_1], r13
		mov		qword [Static_Data_a_1], r10
		mov		r8, qword [rbp+16]
		mov		qword [Static_Data_MAXN_1], r8
		mov		rax, 0
		add		rsp, 40
		pop		rbp
		pop		rbx
		pop		r14
		pop		r12
		pop		r13
		pop		r15
		ret

Block_while_body_1:
		push	r11
		push	r8
		push	r10
		push	0
		call	_getInt
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r12, rax
		push	r11
		push	r8
		push	r10
		push	0
		call	_getInt
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r11, rax
		mov		r8, r12
		mov		qword [rbp], r8
		mov		r8, 1
		mov		qword [rbp+8], r8
		mov		qword [Static_Data_num_1], r15
		push	r11
		push	r10
		mov		rax, qword [rbp]
		mov		rdi, rax
		mov		rsi, r11
		mov		rax, qword [rbp+8]
		mov		rdx, rax
		call	Block_worka_start_1
		pop		r10
		pop		r11
		mov		r12, rax
		mov		qword [Static_Data_num_1], r15
		mov		qword [Static_Data_mod_1], r13
		push	r11
		push	r10
		mov		rax, qword [rbp]
		mov		rdi, rax
		mov		rsi, r11
		mov		rax, qword [rbp+8]
		mov		rdx, rax
		call	Block_workb_start_1
		pop		r10
		pop		r11
		mov		r11, rax
		and		r12, r11

Block_workc_start_1:
		push	r11
		push	r8
		push	r10
		push	0
		mov		rdi, r12
		call	_printlnInt
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		jmp		Block_while_cond_1

Block_for_body_1:
		mov		r8, qword [rbp+24]
		mov		r11, r8
		imul		r11, 8
		add		r11, r15
		push	r11
		push	r8
		push	r10
		mov		rdi, 32
		push	0
		call	malloc
		add		rsp, 8
		pop		r10
		pop		r8
		pop		r11
		mov		r12, rax
		mov		qword [r12], 0
		mov		qword [r12+8], 0
		mov		qword [r12+16], 0
		mov		qword [r12+24], 0

Block_node_start_1:
		mov		qword [r11+8], r12

Block_for_step_2:
		mov		r8, qword [rbp+24]
		inc		r8
		mov		qword [rbp+24], r8
		jmp		Block_for_cond_1

# function buildmax

Block_buildmax_start_1:
		push	r13
		push	r12
		push	r14
		push	rbx
		push	rbp
		mov		rbp, rsp
		mov		r12, qword [Static_Data_num_1]
		mov		r10, qword [Static_Data_a_1]
		mov		r13, 0
		mov		r11, rdx
		imul		r11, 8
		add		r11, r12
		mov		r11, qword [r11+8]
		mov		qword [r11], rdi
		mov		r11, rdx
		imul		r11, 8
		add		r11, r12
		mov		r11, qword [r11+8]
		mov		qword [r11+8], rsi
		and		rdi, -1
		and		rsi, -1
		xor		rax, rax
		cmp		rdi, rsi
		sete	al
		mov		r11, rax
		cmp		r11, 1
		je		Block_if_then_9
		jmp		Block_if_after_4

Block_if_then_9:
		imul		rdx, 8
		add		rdx, r12
		mov		rdx, qword [rdx+8]
		mov		r11, rdi
		imul		r11, 8
		add		r11, r10
		mov		r11, qword [r11+8]
		mov		qword [rdx+16], r11
		imul		rdi, 8
		add		rdi, r10
		mov		rdi, qword [rdi+8]
		mov		r10, rdi
		jmp		Block_buildmax_end_1

Block_if_after_4:
		mov		r13, rdi
		add		r13, rsi
		mov		rbx, rcx
		mov		rcx, 1
		sar		r13, cl
		mov		rcx, rbx
		and		r13, -1
		mov		r11, rdx
		imul		r11, 8
		add		r11, r12
		mov		r11, qword [r11+8]
		mov		r10, rdx
		imul		r10, 2
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rdi
		mov		rdi, qword [rsp]
		mov		rsi, r13
		mov		rdx, r10
		add		rsp, 8
		call	Block_buildmax_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r14, rax
		inc		r13
		mov		r10, rdx
		imul		r10, 2
		inc		r10
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdx
		push	0
		push	rsi
		mov		rdi, r13
		mov		rsi, qword [rsp]
		mov		rdx, r10
		add		rsp, 8
		call	Block_buildmax_start_1
		add		rsp, 8
		pop		rdx
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
		and		r14, -1
		and		r10, -1
		xor		rax, rax
		cmp		r14, r10
		setl	al
		mov		r13, rax
		cmp		r13, 1
		je		Block_if_then_10
		jmp		Block_if_else_6

Block_if_then_10:
		jmp		Block_max_end_2

Block_if_else_6:
		mov		r10, r14

Block_max_end_2:
		mov		qword [r11+16], r10
		imul		rdx, 8
		add		rdx, r12
		mov		rdx, qword [rdx+8]
		mov		r10, qword [rdx+16]

Block_buildmax_end_1:
		mov		rax, r10
		pop		rbp
		pop		rbx
		pop		r14
		pop		r12
		pop		r13
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


