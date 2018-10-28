package quiz;

public class Answer {
		private String answerTitle;
		private byte answerValue;

		public Answer() {	
		}
		
		public Answer(String answerTitle, byte answerValue) {
			this.answerTitle = answerTitle;
			this.answerValue = answerValue;
		}

		public String getAnswerTitle() {
			return answerTitle;
		}

		public void setAnswerTitle(String answerTitle) {
			this.answerTitle = answerTitle;
		}

		public byte getAnswerValue() {
			return answerValue;
		}

		public void setAnswerValue(byte answerValue) {
			this.answerValue = answerValue;
		}
}
