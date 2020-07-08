import java.util.Stack;

class sa {
	public static void main(String args[]) {
		sa.solution(41);
	}
  public static int solution(int n) {

        class Data {
            StringBuffer sb;
            int num;
            int needDiv;
            Data(StringBuffer _sb, int _num, int _needDiv) {
                sb = _sb;
                num = _num;
                needDiv = _needDiv;
            }
            StringBuffer getData() {
                return sb;
            }
            int getNum() {
                return num;
            }
            int getNeedDiv() {
                return needDiv;
            }
            void setData(StringBuffer input) {
                sb = input;
            }
            void setNum(int input) {
                num = input;
            }
            void setNeedDiv(int input) {
                needDiv = input;
            }
        }
        // 312
        // *++*++*++ = ((3+1+1)*3+1+1)*3+1+1 => (((n-1-1)/3-1-1)/3-1-1)/3
        Stack<Data> possible = new Stack<>();
        StringBuffer data = new StringBuffer();
        data.append("++");
        Data first = new Data(data, n-2, 2);
        possible.push(first);
        boolean processed = true;
        while(processed) {
            processed = false;
            Stack<Data> temp = new Stack<>();
            while(!possible.isEmpty()) {
                Data nowData = possible.pop();
                StringBuffer now = nowData.getData();
                if(nowData.getNeedDiv()<0) {
                    continue;
                }
                if(nowData.getNeedDiv()==0) {
                    if(nowData.getNum()==1) {
                        temp.push(nowData);
                    } else {
                        if(nowData.getNum() >= 5) {
                            processed = true;
                            now.insert(0, "++");
                            nowData.setNeedDiv(nowData.getNeedDiv()+2);
                            nowData.setNum(nowData.getNum()-2);
                            temp.push(nowData);
                        }
                    }
                    continue;
                }

                boolean goNext = true;
                int needDiv = nowData.getNeedDiv();
                int nowValue = nowData.getNum();
                while(needDiv > 0) {
                    if(nowValue < 3) {
                        goNext = false;
                        break;
                    }
                    nowValue /= 3;
                    needDiv -= 2;
                }
                if(goNext) {
                    processed = true;   
                    if(nowData.getNum()%3==0) {
                        temp.push(new Data(
                                new StringBuffer('*'+now.toString()),
                                nowData.getNum()/3, 
                                nowData.getNeedDiv()-2));
                    }
                    temp.push(new Data(
                            new StringBuffer('+'+now.toString()),
                            nowData.getNum()-1, 
                            nowData.getNeedDiv()+1));             

                	System.out.println(temp.peek().sb);
                }
            }
            possible = temp;
        }
        int answer = possible.size();
        return answer;
  }
}