import java.util.ArrayList;

public class StringMaker {

	public static void main(String[] args) {
		String str="abc";
		int n=str.length();
		
		
		getAllStrings(0,str);

	

	}
	static void getAllStrings(int index, String str) {
		char [] arr=str.toCharArray();
		String s=""+arr[index];
		String re=""+s;
		for(int k=0;k<str.length();k++) {
			System.out.println(re);
			re=re+s;
		}

		for (int i=0;i<str.length();i++) {
			if(index!=i) {
				s= s+ arr[i];
				System.out.println(s);
				if(s.length()>2) {
					String m=s;
					int l=m.length()-2;
					for(int j=0;j<(m.length()-1)*(m.length()-2);j++) {
						m=swap(m, l,m.length()-1);
						System.out.println(m);
						l--;
						if(l==0)
							l=m.length()-2;
					}
				}
			}
		}
		index++;
		if (index<str.length())
			getAllStrings(index,str);
		
		
	}
	static String swap(String str, int i, int j) 
    { 
        char ch[] = str.toCharArray(); 
        char temp = ch[i]; 
        ch[i] = ch[j]; 
        ch[j] = temp; 
        String s="";
        for(int k=0;k<ch.length;k++)
        	s=s+ch[k];
        return s; 
    } 
  

}
