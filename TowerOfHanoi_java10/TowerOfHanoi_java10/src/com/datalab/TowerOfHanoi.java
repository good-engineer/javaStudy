package com.datalab;

public class TowerOfHanoi {
	
	class Poll {
		String mName;
		
		@SuppressWarnings("unused")
		private Poll() {
			throw new AssertionError("You should give a name of Poll");
		}
		
		public Poll(String name) {
			mName = name;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return mName;
		}
	}
	
	private Poll mStart, mTemp, mGoal;
	private int m=0;
	
	
	public TowerOfHanoi() {
		mStart = new Poll("start");
		mTemp = new Poll("temp");
		mGoal = new Poll("goal");
	}
	/**
	 * solves a Tower of Hanoi problem and print the result.
	 * 
	 * @param n
	 *            The number of all rings
	 */
	public void solve(int n) {
		// [TODO] Fill your code to print logs and trigger the recursion
		int moves;
		moves=towerOfHanoi(n,mStart,mTemp,mGoal);
		System.out.print("Solved with "+moves+" moves!\n");
	}

	/**
	 * Prints a log message to console.
	 * 
	 * @param from
	 *            The pole where the ring be moved from
	 * @param to
	 *            The pole where the ring be moved to
	 */
	private void move(int disk, Poll from, Poll to) {
		// [TODO] Fill your code to print a log message.
		// e.g. : move disk (disk_number) from (name of Poll from) to (name of Poll to)
		System.out.print("move disk "+disk+" from "+from+" to "+to+ "\n");
		
	}

	/**
	 * Solves a Tower of Hanoi problem with given condition.
	 * 
	 * @param n
	 *            The number of all rings
	 * @param from
	 *            The pole which has the all rings
	 * @param goal
	 *            The pole where the rings targets
	 * @param temp
	 *            The intermediate pole
	 * @return The number of ring moves to solve a Tower of Hanoi problem
	 */
	private int towerOfHanoi(int n, Poll from , Poll intermediate, Poll to) {
		// [TODO] Fill your code to solve the Tower of Hanoi problem.
		if(n==1) {
			move(n,from,to);
			m++;
			return m;
			
		}
		
		towerOfHanoi(n-1,from,to,intermediate);
		move(n,from,to);
		m++;
		towerOfHanoi(n-1,intermediate,from,to);
		
		return m;
	}

}
