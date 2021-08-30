package programmers;

import java.util.Stack;

/**
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 *
 * 프로그래머스 - 주식가격
 *
 * - 처음에는 2중반복문을 통한 브루트포스로 풀었으나,
 * - 스택을 ㅇ용한 풀이가 있는것을 알고 다시 풀이.
 *
 * */
public class 주식가격 {

	public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
        	while(!st.isEmpty() && prices[st.peek()] > prices[i]) {
        		answer[st.peek()] = i-st.peek();
        		st.pop();
        	}
        	st.push(i);
		}

        while(!st.isEmpty()) {
        	answer[st.peek()] = answer.length - st.peek();
        	st.pop();
        }
        return answer;
    }

}
