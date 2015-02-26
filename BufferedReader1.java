import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;
 
public class BufferedReader1 {
	public static boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
	public static void reader() {
		String[] array=new String[15];
		BufferedReader br = null;
		String[] cmdarray=new String[100];
		String[][] cmddarray=new String[100][100];
		int count=0;
		int k=0;
		
		
		int m1=0;
		int m2=0;
		int m=0;
		String mc;
		
		int d1=0;
		int d2=0;
		int d=0;
		String dc;
		int syn=0;
		int s1=0;
		int s2=0;
		int s=0;
		String sc;
		
		int a1=0;
		int a2=0;
		int a=0;
		String ac;
		
		Map mMap = new HashMap();
		try {
 
			String sCurrentLine;
			
			br = new BufferedReader(new FileReader("C:/Users/envy 17/Desktop/Lab2/myfile.txt"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				cmdarray[count]=sCurrentLine;
				count++;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		for(int i=0;i<count;i++){
		//System.out.println("Tokenizing string "+cmdarray[i]);
		String temp=cmdarray[i];
		StringTokenizer st = new StringTokenizer(temp);
		StringTokenizer stforsyn = new StringTokenizer(temp);
		while (st.hasMoreElements()) {
			String temp1=st.nextElement().toString();
			stforsyn.nextElement();
			if(temp1.equalsIgnoreCase("Let"))
			{
				//System.out.println("Let here--->"+temp1);
				//System.out.println("var here--->"+st.nextElement());
				String var=st.nextElement().toString();
				
				//System.out.println("= here--->"+st.nextElement());
				st.nextElement();
				//System.out.println("Val here--->"+st.nextElement());
				int val=Integer.parseInt(st.nextElement().toString());
				mMap.put(var,val);
			}
			else if (temp1.equalsIgnoreCase("print")){
				System.out.println("Print here");
				String printable=st.nextElement().toString();
				System.out.println(mMap.get(printable));
			}
			else if(!stforsyn.nextElement().toString().equals("=")){
				System.out.println("Syntax Error 'Invalid Assignment' in command, "+temp);
				syn=1;
			}
			else if(!isAlpha(temp1) && !temp1.equals("+")&& !temp1.equals("*")&& !temp1.equals("/") && !temp1.equals("-")&& !temp1.equals("=")){
				//System.out.println("In here with temp1--->"+temp1);
				System.out.println("Syntax Error 'Invalid Assignment' in command, "+temp);
				break;
			}
			else{
				if(mMap.containsKey(temp1)){
					
				}
				else {
					if(isAlpha(temp1)){
					System.out.println("Variable "+temp1+" not initialized");}
					break;
				}
				k=0;
				//StringTokenizer st1 = new StringTokenizer(temp,"+*-/=");
				while (st.hasMoreElements()) {
					String t=st.nextElement().toString();
					if(!t.equals("=")){
						array[k]=t;
					}
					k++;
				}
				for(int dy=0;dy<array.length;dy++){
					//System.out.println(array[dy]);
				}
			//	System.out.println("Checking if the string has multiplication");
				if(Arrays.asList(array).contains("*")){
			//		System.out.println("Multiplication found");

					int indexofmul=Arrays.asList(array).indexOf("*");
					
					if(isAlpha(array[indexofmul-1])){
						m1=(int) mMap.get(array[indexofmul-1]);
						
					}
					else{
						m1=Integer.parseInt(array[indexofmul-1]);
					}
					if(isAlpha(array[indexofmul+1])){
						m2=(int) mMap.get(array[indexofmul+1]);
					}
					else{
					m2=Integer.parseInt(array[indexofmul+1]);
					}
					
					
					
					m=m1*m2;
					mc=Integer.toString(m);
					array[indexofmul]=mc;
					array[indexofmul+1]=Integer.toString(0);
					array[indexofmul-1]=Integer.toString(0);
//					System.out.println("MUL here--->"+m);
					
	//				System.out.println("Multiplication found, now checking if division exists");
					if(Arrays.asList(array).contains("/")){
		//				System.out.println("Multiplication found, division found");
						int indexofdiv=Arrays.asList(array).indexOf("/");
						/*while(indexofdiv--==0){
							System.out.println("indexofdiv-- here--->"+indexofdiv);
						}
						while(indexofdiv++==0){
							System.out.println("indexofdiv++ here--->"+indexofdiv);
						}*/
						//if(Integer.parseInt(array[indexofdiv-1])!=0 && Integer.parseInt(array[indexofdiv+1])!=0){
						if(indexofmul<indexofdiv+1){
					    d1=Integer.parseInt(array[indexofmul]);
						d2=Integer.parseInt(array[indexofdiv+1]);
						d=d1/d2;
						}
						
						else{
							d1=Integer.parseInt(array[indexofmul]);
							d2=Integer.parseInt(array[indexofdiv-1]);
							d=d2/d1;
						}
						

						dc=Integer.toString(d);
						array[indexofdiv]=dc;
						array[indexofdiv+1]=Integer.toString(0);
						array[indexofdiv-1]=Integer.toString(0);
			//			System.out.println("div here--->"+dc);
						
				//		System.out.println("Multiplication found, division found, and now checking if addition exists");
						if(Arrays.asList(array).contains("+")){
					//		System.out.println("Multiplication found, division found, addition found");
							int indexofadd=Arrays.asList(array).indexOf("+");
							
							
							if(indexofdiv<indexofadd+1){
							    a1=Integer.parseInt(array[indexofdiv]);
								a2=Integer.parseInt(array[indexofadd+1]);
								a=a1+a2;
								}
								
								else{
									a1=Integer.parseInt(array[indexofdiv]);
									a2=Integer.parseInt(array[indexofadd-1]);
									a=a2+a1;
								}
							
							
							ac=Integer.toString(a);
							array[indexofadd]=ac;
							array[indexofadd+1]=Integer.toString(0);
							array[indexofadd-1]=Integer.toString(0);
						//	System.out.println("add here--->"+ac);
							//System.out.println(c1);
							//System.out.println("Multiplication found, division found, addition found, now checking if subtraction exists");

							if(Arrays.asList(array).contains("-")){
								//System.out.println("Multiplication found, division found, addition found, subtraction found");
								int indexofsub=Arrays.asList(array).indexOf("-");
								
								
								if(indexofadd<indexofsub+1){
								    s1=Integer.parseInt(array[indexofadd]);
									s2=Integer.parseInt(array[indexofsub+1]);
									s=s1-s2;
									}
									
									else{
										s1=Integer.parseInt(array[indexofadd]);
										s2=Integer.parseInt(array[indexofsub-1]);
										s=s2-s1;
									}
								
								
								sc=Integer.toString(s);
								array[indexofsub]=ac;
								array[indexofsub+1]=Integer.toString(0);
								array[indexofsub-1]=Integer.toString(0);
//								System.out.println("sub here--->"+sc);
								mMap.put(temp1,s);
	//							System.out.println("Now printing the value of "+temp1);
		//						System.out.println("Which is "+mMap.get(temp1));
								
							}//subtraction ends here
							else{
			//					System.out.println("Multiplication found, division found, addition found, SUBTRACTION NOT FOUND");
				//				System.out.println("Now printing the value of "+temp1);
								mMap.put(temp1,a);
					//			System.out.println("Which is "+mMap.get(temp1));
							}
							
							
							}//addition ends here
						else{
						//	System.out.println("Multiplication found, division found, ADDITION NOT FOUND checking if subtraction exists");
							if(Arrays.asList(array).contains("-")){

							
							int indexofsub=Arrays.asList(array).indexOf("-");
							
							
							if(indexofdiv<indexofsub+1){
							    s1=Integer.parseInt(array[indexofdiv]);
								s2=Integer.parseInt(array[indexofsub+1]);
								s=s1-s2;
								}
								
								else{
									s1=Integer.parseInt(array[indexofdiv]);
									s2=Integer.parseInt(array[indexofsub-1]);
									s=s2-s1;
								}
							
							
							sc=Integer.toString(s);
							array[indexofsub]=sc;
							array[indexofsub+1]=Integer.toString(0);
							array[indexofsub-1]=Integer.toString(0);
							//System.out.println("sub here--->"+sc);
							mMap.put(temp1,s);}
							//System.out.println("Now printing the value of "+temp1);
							//System.out.println("Which is "+mMap.get(temp1));}
							else{
								//System.out.println("Multiplication found, division found, ADDITION NOT FOUND, and SUBTRACTION NOT FOUND");
								mMap.put(temp1,d);
								//System.out.println("Now printing the value of "+temp1);
								//System.out.println("Which is "+mMap.get(temp1));
							}
						}//subtraction ends here
							
							
							
							
							
							
							
							//System.out.println("Now printing the value of "+temp1);
							//mMap.put(temp1,d);
							//System.out.println("Which is "+mMap.get(temp1));
							
						
						
						}//division ends here
					else{
						//System.out.println("Multiplication found,DIVISION NOT FOUND");
						//System.out.println("Now printing the value of "+temp1);
						//System.out.println("Which is "+mMap.get(temp1));
						mMap.put(temp1,m);
						//System.out.println("Multiplication found, then division not found and now checking addition");
						//System.out.println("Checking if addition exists");
						if(Arrays.asList(array).contains("+")){
						//	System.out.println("Multiplication found, DIVISION NOT FOUND, ADDITION FOUND");
							int indexofadd=Arrays.asList(array).indexOf("+");		
							if(indexofmul<indexofadd+1){
							    a1=Integer.parseInt(array[indexofmul]);
								a2=Integer.parseInt(array[indexofadd+1]);
								a=a1+a2;
								}
								
								else{
									a1=Integer.parseInt(array[indexofmul]);
									a2=Integer.parseInt(array[indexofadd-1]);
									a=a2+a1;
								}
							
							
							ac=Integer.toString(a);
							array[indexofadd]=ac;
							array[indexofadd+1]=Integer.toString(0);
							array[indexofadd-1]=Integer.toString(0);
							//System.out.println("add here--->"+ac);
							//System.out.println(c1);
							
							//System.out.println("Multiplication found, DIVISION NOT FOUND, then addition found, and now checking subtraction");
							if(Arrays.asList(array).contains("-")){
								//System.out.println("Multiplication found, DIVISION NOT FOUND, then addition found, subtraction found");
								int indexofsub=Arrays.asList(array).indexOf("-");
								
								
								if(indexofadd<indexofsub+1){
								    s1=Integer.parseInt(array[indexofadd]);
									s2=Integer.parseInt(array[indexofsub+1]);
									s=s1-s2;
									}
									
									else{
										s1=Integer.parseInt(array[indexofadd]);
										s2=Integer.parseInt(array[indexofsub-1]);
										s=s2-s1;
									}
								
								
								sc=Integer.toString(s);
								array[indexofsub]=sc;
								array[indexofsub+1]=Integer.toString(0);
								array[indexofsub-1]=Integer.toString(0);
								//System.out.println("sub here--->"+sc);
								mMap.put(temp1,s);
								//System.out.println("Now printing the value of "+temp1);
								//System.out.println("Which is "+mMap.get(temp1));
								
							}//subtraction ends here
							else{
								//System.out.println("Subtraction not found");
							//	System.out.println("Multiplication found, DIVISION NOT FOUND, then addition found, and SUBTRACTION NOT FOUND");
							//	System.out.println("Now printing the value of "+temp1);
								mMap.put(temp1,a);
							//	System.out.println("Which is "+mMap.get(temp1));

							}
							
							
						}//addition ends here
						else{
							//System.out.println("Multiplication found,DIVISION NOT FOUND, ADDITION NOT FOUND, and now checking subtraction");
							if(Arrays.asList(array).contains("-")){
							//System.out.println("Multiplication found, DIVISION NOT FOUND, ADDITION NOT FOUND, and subtraction found");

							int indexofsub=Arrays.asList(array).indexOf("-");
							
							
							if(indexofmul<indexofsub+1){
							    s1=Integer.parseInt(array[indexofmul]);
								s2=Integer.parseInt(array[indexofsub+1]);
								s=s1-s2;
								}
								
								else{
									s1=Integer.parseInt(array[indexofmul]);
									s2=Integer.parseInt(array[indexofsub-1]);
									s=s2-s1;
								}
							
							
							sc=Integer.toString(s);
							array[indexofsub]=sc;
							array[indexofsub+1]=Integer.toString(0);
							array[indexofsub-1]=Integer.toString(0);
							//System.out.println("sub here--->"+sc);
							mMap.put(temp1,s);
							//System.out.println("Now printing the value of "+temp1);
							//System.out.println("Which is "+mMap.get(temp1));
							
						}//subtraction ends here
							else{
								//System.out.println("ONLY Multiplication found, DIVISION NOT FOUND, ADDITION NOT FOUND, and SUBTRACTION NOT FOUND");
								mMap.put(temp1,m);
								//System.out.println("Now printing the value of "+temp1);
								//System.out.println("Which is "+mMap.get(temp1));
							}
						
						}
						
					}
						
						}//multiplication ends here		
				
				else if(Arrays.asList(array).contains("+")){
					//System.out.println("MULTIPLICATION NOT FOUND, ADDITION FOUND");
						a=0;
						a1=0;
						a2=0;
						int indexofadd=Arrays.asList(array).indexOf("+");
						
						if(isAlpha(array[indexofadd-1])){
							a1=(int) mMap.get(array[indexofadd-1]);
						//	System.out.println("value of m1--->"+a1);
						}
						else{
							a1=Integer.parseInt(array[indexofadd-1]);
							//System.out.println("value of m1--->"+a1);
						}
						if(isAlpha(array[indexofadd+1])){
							a2=(int) mMap.get(array[indexofadd+1]);
							//System.out.println("value of m2--->"+a2);
						}
						else{
						a2=Integer.parseInt(array[indexofadd+1]);
						//System.out.println("value of m2--->"+a2);
						}
				
						a=a1+a2;
						
						ac=Integer.toString(a);
						array[indexofadd]=ac;
						array[indexofadd+1]=Integer.toString(0);
						array[indexofadd-1]=Integer.toString(0);
						//System.out.println("add here--->"+ac);						
						mMap.put(temp1,a);
						//System.out.println("Now printing the value of "+temp1);
						//System.out.println("Which is "+mMap.get(temp1));
				}
				else if(Arrays.asList(array).contains("-")){
					//System.out.println("MULTIPLICATION NOT FOUND, ADDITION NOT FOUND, SUBTRACTION FOUND");
						s=0;
						s1=0;
						s2=0;
						int indexofsub=Arrays.asList(array).indexOf("-");
						
						if(isAlpha(array[indexofsub-1])){
							s1=(int) mMap.get(array[indexofsub-1]);
						//	System.out.println("value of s1--->"+s1);
						}
						else{
							s1=Integer.parseInt(array[indexofsub-1]);
							//System.out.println("value of s1--->"+s1);
						}
						if(isAlpha(array[indexofsub+1])){
							s2=(int) mMap.get(array[indexofsub+1]);
					//		System.out.println("value of s2--->"+s2);
						}
						else{
						s2=Integer.parseInt(array[indexofsub+1]);
						//System.out.println("value of s2--->"+s2);
						}
				
						s=s1-s2;
						
						sc=Integer.toString(s);
						array[indexofsub]=sc;
						array[indexofsub+1]=Integer.toString(0);
						array[indexofsub-1]=Integer.toString(0);
						//System.out.println("Sub here--->"+sc);						
						mMap.put(temp1,s);
						//System.out.println("Now printing the value of "+temp1);
						//System.out.println("Which is "+mMap.get(temp1));
				}
				else if(Arrays.asList(array).contains("/")){
					//System.out.println("MULTIPLICATION NOT FOUND, ADDITION NOT FOUND, SUBTRACTION NOT FOUND DIVISION FOUND");
						d=0;
						d1=0;
						d2=0;
						int indexofdiv=Arrays.asList(array).indexOf("/");
						
						if(isAlpha(array[indexofdiv-1])){
							d1=(int) mMap.get(array[indexofdiv-1]);
						//	System.out.println("value of d1--->"+d1);
						}
						else{
							d1=Integer.parseInt(array[indexofdiv-1]);
							//System.out.println("value of d1--->"+d1);
						}
						if(isAlpha(array[indexofdiv+1])){
							d2=(int) mMap.get(array[indexofdiv+1]);
						//	System.out.println("value of d2--->"+d2);
						}
						else{
						d2=Integer.parseInt(array[indexofdiv+1]);
						//System.out.println("value of d2--->"+d2);
						}
				
						d=d1/d2;
						
						dc=Integer.toString(d);
						array[indexofdiv]=dc;
						array[indexofdiv+1]=Integer.toString(0);
						array[indexofdiv-1]=Integer.toString(0);
						//System.out.println("div here--->"+dc);						
						mMap.put(temp1,d);
						//System.out.println("Now printing the value of "+temp1);
						//System.out.println("Which is "+mMap.get(temp1));
				}
				
					}//else ends here 
					
				}
		}//for ends here
		k=0;
		
		//while ends here
		/*
				if(Arrays.asList(array).contains("/")){
					int indexofdiv=Arrays.asList(array).indexOf("/");
					int m1=0,m2=0;
					while(indexofdiv--==0){
						System.out.println("indexofdiv-- here--->"+indexofdiv);
					}
					while(indexofdiv++==0){
						System.out.println("indexofdiv++ here--->"+indexofdiv);
					}
					if(Integer.parseInt(array[indexofdiv-1])!=0 && Integer.parseInt(array[indexofdiv+1])!=0){
					m1=Integer.parseInt(array[indexofdiv-1]);
					m2=Integer.parseInt(array[indexofdiv+1]);
					}
					int c1=m1/m2;
					String c2=Integer.toString(c1);
					array[indexofdiv]=c2;
					array[indexofdiv+1]=Integer.toString(0);
					array[indexofdiv-1]=Integer.toString(0);
					System.out.println("div here--->"+c1);
					//System.out.println(c1);
					
				}
				if(Arrays.asList(array).contains("+")){
					int indexofadd=Arrays.asList(array).indexOf("+");
					int m1=Integer.parseInt(array[indexofadd-1]);
					int m2=Integer.parseInt(array[indexofadd+1]);
					int c1=m1+m2;
					String c2=Integer.toString(c1);
					array[indexofadd]=c2;
					array[indexofadd+1]=Integer.toString(0);
					array[indexofadd-1]=Integer.toString(0);
					System.out.println("add here--->"+c1);
					//System.out.println(c1);
					
				}
				if(Arrays.asList(array).contains("-")){
					int indexofsub=Arrays.asList(array).indexOf("-");
					int m1=Integer.parseInt(array[indexofsub-1]);
					int m2=Integer.parseInt(array[indexofsub+1]);
					int c1=m1-m2;
					String c2=Integer.toString(c1);
					array[indexofsub]=c2;
					array[indexofsub+1]=Integer.toString(0);
					array[indexofsub-1]=Integer.toString(0);
					//System.out.println(c1);
					System.out.println("s here--->"+c1);
				}*/
				/*System.out.println("var here--->"+temp1);
				System.out.println("= here--->"+st.nextElement());
				System.out.println("= here--->"+st.nextElement());
				System.out.println("val here--->"+st.nextElement());
				System.out.println("val here--->"+st.nextElement());
			}*/
				
		/*if(temp.contains("+")){
			System.out.println("+ here--->"+temp);
			StringTokenizer st1 = new StringTokenizer(temp,"+=");
			while (st1.hasMoreElements()) {
				System.out.println(st1.nextElement());
				}
			
		}
		
		if(temp.contains("-")){
			System.out.println("- here--->"+temp);
			StringTokenizer st1 = new StringTokenizer(temp,"-=");
			while (st1.hasMoreElements()) {
				System.out.println(st1.nextElement());
				}
		}
		if(temp.contains("/")){
			System.out.println("/ here--->"+temp);
			StringTokenizer st1 = new StringTokenizer(temp,"*=");
			while (st1.hasMoreElements()) {
				System.out.println(st1.nextElement());
				}
		}
		if(temp.contains("*")){
			System.out.println("* here--->"+temp);
			StringTokenizer st1 = new StringTokenizer(temp,"/=");
			while (st1.hasMoreElements()) {
				System.out.println(st1.nextElement());
				}
		}*/

		java.util.Iterator iter = mMap.entrySet().iterator();
		 
		while (iter.hasNext()) {
			Map.Entry mEntry = (Map.Entry) iter.next();
			System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
		}
	}
}
