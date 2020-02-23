package com.daling.util;
/**
 */

public class DigitCharVerifyTools {
	
	private static int[] offsetCode = {7,8,5,1,3,4};

	private static int[] F0A05SeedIndex = {1,0,3,2,4,6,5,7};
	private static int[] F0A16SeedIndex = {0,2,1,3,4,5,6,7};
	private static int[] F0A27SeedIndex = {2,0,1,3,4,5,6,7};
	private static int[] F0A38SeedIndex = {7,2,3,1,4,5,6,0};
	private static int[] F0A49SeedIndex = {1,0,3,2,5,4,7,6};
	private static int[] factor2minus = {0,2,4,6,8,9,1,3,5,7}; 
	private static int[] factor3origi = {0,3,6,9,2,5,8,1,4,7}; 
	private static int[] factor5plus  = {0,5,1,6,2,7,3,8,4,9}; 
	private static int[] factor5minus = {0,5,9,4,8,3,7,2,6,1}; 
	private static String[] factorType = {"2-","2-","3 ","5-"}; 
	private static int[] F0EQ0ObfuscateIndex = {5,4,3,2,1,0};
	private static int[] F0EQ1ObfuscateIndex = {2,3,0,1,5,4};
	private static int[] F0EQ2ObfuscateIndex = {3,4,5,0,1,2};
	private static int[] F0EQ3ObfuscateIndex = {4,1,2,5,0,3};
	private static int[] F0EQ4ObfuscateIndex = {3,5,2,0,4,1};
	private static int[] F0EQ5ObfuscateIndex = {0,2,1,4,3,5};
	private static int[] F0EQ6ObfuscateIndex = {1,0,3,2,5,4};
	private static int[] F0EQ7ObfuscateIndex = {0,1,2,3,4,5};
	private static int[] F0EQ8ObfuscateIndex = {5,1,4,3,2,0};
	private static int[] F0EQ9ObfuscateIndex = {4,5,2,1,0,3};
	/**
	 * 根据12位物流码和6位盐值，计算出6位校验码，生成18位防伪码
	 * @param logiCharStr the name of the property to get.
	 * @param saltStr
	 * @return 包含12位物流码+6位校验码的18位防伪码.
	 * @throws NumberFormatException
	 */
    public static String secureCharGenrate(String logiCharStr, String saltStr) throws NumberFormatException {

        //检测传入的字符是否均为阿拉伯数字，如果不是则会抛出异常
        Double tmpdouble1 = Double.valueOf(logiCharStr);
        Double tmpdouble2 = Double.valueOf(saltStr);
        
        //定义6位的校验码字符数组
        char[] V6charArray = new char[6];
        //检测字符长度是否符合要求
        char[] A12charArray = logiCharStr.toCharArray();
        char[] S6charArray = saltStr.toCharArray();
        //if(A12charArray.length != 12)
            //throw new NumberFormatException("the length of logiChar12bitStr is not 12 bit");
        if(S6charArray.length != 6)
            throw new NumberFormatException("the length of saltStr is not 6 bit");
        
        //计算F(0) char
        char F0 =  DigitCharVerifyTools.F0_Generate(A12charArray[11], A12charArray[10], S6charArray);
        //System.out.println("F0="+F0);
        //
        V6charArray[0] = DigitCharVerifyTools.V5_Generate(A12charArray, S6charArray);
        //System.out.println("V5="+V6charArray[0]);
        //
        V6charArray[1] = DigitCharVerifyTools.V4_Generate(A12charArray);
        //System.out.println("V4="+V6charArray[1]);
        //
        V6charArray[2] = DigitCharVerifyTools.V3_Generate(A12charArray);
        //System.out.println("V3="+V6charArray[2]);
        //
        V6charArray[3] = DigitCharVerifyTools.V2_Generate(A12charArray,V6charArray);
        //System.out.println("V2="+V6charArray[3]);
        //
        V6charArray[4] = DigitCharVerifyTools.V1_Generate(V6charArray);
        //System.out.println("V1="+V6charArray[4]);
        //
        V6charArray[5] = DigitCharVerifyTools.V0_Generate(A12charArray,V6charArray);
        //System.out.println("V0="+V6charArray[5]);

        //System.out.println("数值偏移前V6charArray="+new String(V6charArray));
        //数值偏移
        int tmpint = 0;
        for (int i = 0; i < V6charArray.length; i++ ){
            tmpint = (Character.digit(V6charArray[i], 10) + offsetCode[i]) % 10;
            V6charArray[i] = Character.forDigit(tmpint,10);
        }
        //System.out.println("数值偏移后V6charArray="+new String(V6charArray));

        //位置混淆
        //
        V6charArray = ObfuscateVerifyCodeViaF0(F0, V6charArray);
        //System.out.println("位置混淆后V6charArray="+new String(V6charArray));
        //对最终结果形成字符串返回
        char resultCharArray[] = new char[A12charArray.length + V6charArray.length];
        System.arraycopy(A12charArray, 0, resultCharArray, 0, A12charArray.length);
        System.arraycopy(V6charArray,  0, resultCharArray, A12charArray.length, V6charArray.length);

        //System.out.println("resultCharArray="+new String(resultCharArray));
        return new String(resultCharArray);

    }
    /**
     * 根据18位防伪码和6位盐值，计算出该码是否有效
     */
    public static boolean secureCharVerify(String logiCharStr,String saltStr) throws NumberFormatException {
        //检测传入的字符是否均为阿拉伯数字，如果不是则会抛出异常
        Double tmpdouble1 = Double.valueOf(logiCharStr);
        Double tmpdouble2 = Double.valueOf(saltStr);
        
        if(saltStr.length() != 6)
            throw new NumberFormatException("the length of saltStr is not 6 bit");
        int len = logiCharStr.length();
        String right18bitStr = secureCharGenrate(logiCharStr.substring(0,len-6), saltStr);
        //System.out.println("secureChar18bit_Last6bit="+secureChar18bit.substring(12,18));
        //System.out.println("right18bitStr_Last6bit  ="+right18bitStr.substring(12,18));
        return right18bitStr.substring(len-6,len).equals(logiCharStr.substring(len-6,len));
    }


	public static String SecureChar18bitGenrate(String logiChar12bitStr, String saltStr) throws NumberFormatException {

		Double tmpdouble1 = Double.valueOf(logiChar12bitStr);
		Double tmpdouble2 = Double.valueOf(saltStr);
		
		char[] V6charArray = new char[6];
		char[] A12charArray = logiChar12bitStr.toCharArray();
		char[] S6charArray = saltStr.toCharArray();
		if(A12charArray.length != 12)
			throw new NumberFormatException("the length of logiChar12bitStr is not 12 bit");
		if(S6charArray.length != 6)
			throw new NumberFormatException("the length of saltStr is not 6 bit");
		
		char F0 =  DigitCharVerifyTools.F0_Generate(A12charArray[11], A12charArray[10], S6charArray);
		V6charArray[0] = DigitCharVerifyTools.V5_Generate(A12charArray, S6charArray);
		V6charArray[1] = DigitCharVerifyTools.V4_Generate(A12charArray);
		V6charArray[2] = DigitCharVerifyTools.V3_Generate(A12charArray);
		V6charArray[3] = DigitCharVerifyTools.V2_Generate(A12charArray,V6charArray);
		V6charArray[4] = DigitCharVerifyTools.V1_Generate(V6charArray);
		V6charArray[5] = DigitCharVerifyTools.V0_Generate(A12charArray,V6charArray);
		int tmpint = 0;
		for (int i = 0; i < V6charArray.length; i++ ){
			tmpint = (Character.digit(V6charArray[i], 10) + offsetCode[i]) % 10;
			V6charArray[i] = Character.forDigit(tmpint,10);
		}
		V6charArray = ObfuscateVerifyCodeViaF0(F0, V6charArray);
		char resultCharArray[] = new char[A12charArray.length + V6charArray.length];
		System.arraycopy(A12charArray, 0, resultCharArray, 0, A12charArray.length);
		System.arraycopy(V6charArray,  0, resultCharArray, A12charArray.length, V6charArray.length);

		return new String(resultCharArray);

	}
	public static boolean SecureChar18bitVerify(String secureChar18bit,String saltStr) throws NumberFormatException {
		
		if(secureChar18bit.length() != 18)
			throw new NumberFormatException("the length of secureChar18bit is not 18 bit");
		if(saltStr.length() != 6)
			throw new NumberFormatException("the length of saltStr is not 6 bit");

		String right18bitStr = SecureChar18bitGenrate(secureChar18bit.substring(0,12), saltStr);
		return right18bitStr.substring(12,18).equals(secureChar18bit.substring(12,18));
	}
	private static char V0_Generate(char[] A12charArray,char[] V6charArray) throws NumberFormatException {
		char tmpV0SeedCharArray[] = new char[A12charArray.length + 5];
		System.arraycopy(A12charArray, 0, tmpV0SeedCharArray, 0, A12charArray.length);
		System.arraycopy(V6charArray,  0, tmpV0SeedCharArray, A12charArray.length, 5);//V5,V4,V3,V2,V1
		return DigitCharVerifyTools.ISO7064_MOD11minus2_Generate(tmpV0SeedCharArray);
	}
	private static char V1_Generate(char[] V6charArray) throws NumberFormatException {
		char tmpV1SeedCharArray[] = new char[4];
		System.arraycopy(V6charArray, 0, tmpV1SeedCharArray, 0, 4);
		return DigitCharVerifyTools.Inner4bitShopVerifyCode_Generate(tmpV1SeedCharArray);
	}
	private static char V2_Generate(char[] A12charArray,char[] V6charArray) throws NumberFormatException {
		char tmpV2SeedCharArray[] = new char[A12charArray.length + 3];
		System.arraycopy(A12charArray, 0, tmpV2SeedCharArray, 0, A12charArray.length);
		System.arraycopy(V6charArray,  0, tmpV2SeedCharArray, A12charArray.length, 3);//V5,V4,V3
		return DigitCharVerifyTools.ISO7812_Luhn_Generate(tmpV2SeedCharArray);
	}
	private static char V3_Generate(char[] A12charArray) throws NumberFormatException 
	{
		return DigitCharVerifyTools.ISO15420_EAN13_Generate(A12charArray);
	}
	private static char V4_Generate(char[] A12charArray) throws NumberFormatException 
	{
		return DigitCharVerifyTools.ISO7064_MOD11comma10_Generate(A12charArray);
	}
	private static char V5_Generate(char[] A12charArray, char[] S6charArray) throws NumberFormatException {
		char tmpV5SeedCharArray[] = new char[A12charArray.length+S6charArray.length];
		System.arraycopy(A12charArray, 0, tmpV5SeedCharArray, 0, A12charArray.length);
		System.arraycopy(S6charArray,  0, tmpV5SeedCharArray, A12charArray.length, S6charArray.length);
		return DigitCharVerifyTools.ISO7812_Luhn_Generate(tmpV5SeedCharArray);

	}
	private static char F0_Generate(char A0, char A1, char[] S6charArray) throws NumberFormatException {
        StringBuilder tmpF0SeedStrBfr = new StringBuilder(8); 
		tmpF0SeedStrBfr.append(A1);
		tmpF0SeedStrBfr.append(A0);
		tmpF0SeedStrBfr.append(S6charArray);

		int[] caseIndex = null ;
		char[] tmpF0SeedCharArray = new char[8];
		switch(A0){
			case '0':
			case '5':
				caseIndex = F0A05SeedIndex;
				break;
			case '1':
			case '6':
				caseIndex = F0A16SeedIndex;
				break;
			case '2':
			case '7':
				caseIndex = F0A27SeedIndex;
				break;
			case '3':
			case '8':
				caseIndex = F0A38SeedIndex;
				break;
			case '4':
			case '9':
				caseIndex = F0A49SeedIndex;
		}

		for(int i=0; i<tmpF0SeedCharArray.length; i++){
			tmpF0SeedCharArray[i] = tmpF0SeedStrBfr.charAt(caseIndex[i]);
		}
		String tmpF0SeedStr = new String(tmpF0SeedCharArray);
		return DigitCharVerifyTools.ISO7812_Luhn_Generate(tmpF0SeedCharArray);

	}
	private static char[] ObfuscateVerifyCodeViaF0(char F0, char[] V6charArray) throws NumberFormatException {
		if (V6charArray.length != 6)
			throw new NumberFormatException("Parameter char[] length must be 6");
		int[] posiObfuscateIndex = null; 
		//
		switch(F0){
			case '0':
				posiObfuscateIndex = F0EQ0ObfuscateIndex;
				break;
			case '1':
				posiObfuscateIndex = F0EQ1ObfuscateIndex;
				break;
			case '2':
				posiObfuscateIndex = F0EQ2ObfuscateIndex;
				break;
			case '3':
				posiObfuscateIndex = F0EQ3ObfuscateIndex;
				break;
			case '4':
				posiObfuscateIndex = F0EQ4ObfuscateIndex;
				break;
			case '5':
				posiObfuscateIndex = F0EQ5ObfuscateIndex;
				break;
			case '6':
				posiObfuscateIndex = F0EQ6ObfuscateIndex;
				break;
			case '7':
				posiObfuscateIndex = F0EQ7ObfuscateIndex;
				break;
			case '8':
				posiObfuscateIndex = F0EQ8ObfuscateIndex;
				break;
			case '9':
				posiObfuscateIndex = F0EQ9ObfuscateIndex;
				break;
		}
		char[] tmpNewV6CharArray = new char[V6charArray.length];
		for (int i =0; i< V6charArray.length; i++ ){
			tmpNewV6CharArray[i] = V6charArray[posiObfuscateIndex[i]];
		}
		return tmpNewV6CharArray;
	}
	private static char Inner4bitShopVerifyCode_Generate(char[] number) throws NumberFormatException {
		if (number.length != 4)
			throw new NumberFormatException("Parameter char[] length must be 4");

		//System.out.println("InnerShopVerifyCode4bit_Generate("+new String(number)+")");

		int[] iNum = new int[4];
		iNum[0] = factor2minus[Character.digit(number[0], 10)];
		iNum[1] = factor2minus[Character.digit(number[1], 10)];
		iNum[2] = factor3origi[Character.digit(number[2], 10)];
		iNum[3] = factor5minus[Character.digit(number[3], 10)];

		int digit = 0;
		for (int i=0;i<4 ;i++ ){
			digit += iNum[i];
		}
		digit = (3 * digit)%10;

		return Character.forDigit(digit,10);
	}
	public static char ISO7064_MOD11minus2_Generate(char[] number) throws NumberFormatException {
		int s1 = 0,	s2 = 0;

		for (int i = 0; i < number.length; i++) {
			int digit = Character.digit(number[i], 10);
			if(digit < 0) 
				throw new NumberFormatException(number[i]+" is not a number");
			s1 += digit;
			s1 = s1*2;
		}
		s2 = s1%11;
		s2 = ((11-s2)%11+1)%11;
		if(s2 == 10) 
			s2 = 0;
		return Character.forDigit(s2,10);

	}
	public static boolean ISO7064_MOD11minus2_Verify(char[]  number) throws NumberFormatException {
		int s1 = 0,	s2 = 0;

		for (int i = 0; i < number.length-1; i++) {
			int digit = Character.digit(number[i], 10);
			if(digit < 0) 
				throw new NumberFormatException(number[i]+" is not a number");
			s1 += digit;
			s1 = s1*2;
		}
		s2 = (s1 + Character.digit(number[number.length-1],10))%11;
		if(s2 ==1)
			return true;
		else{
			if( Character.digit(number[number.length-1], 10) == 0 && s2 == 2)
				return true;
			else
				return false;
		}

	}
	public static char ISO7064_MOD11comma10_Generate(char[] number) throws NumberFormatException {
		int s1 = 10,s2 = 0;

		for (int i = 0; i < number.length; i++) {
			int digit = Character.digit(number[i], 10);
			if(digit < 0) 
				throw new NumberFormatException(number[i]+" is not a number");
			s1 += digit;
			s1 = s1%10;
			if(s1 == 0) 
				s1 = 10;
			s1 = (s1*2)%11;
		}
		s2 = s1%10;
		s2 = ((10-s2)%10+1)%10;
		return Character.forDigit(s2,10);
	}
	public static boolean ISO7064_MOD11comma10_Verify(char[] number) throws NumberFormatException {
		int s1 = 10,s2 = 0;

		for (int i = 0; i < number.length-1; i++) {
			int digit = Character.digit(number[i], 10);
			if(digit < 0) 
				throw new NumberFormatException(number[i]+" is not a number");
			s1 += digit;
			s1 = s1%10;
			if(s1 == 0) 
				s1 = 10;
			s1 = (s1*2)%11;
		}
		s2 = (s1 + Character.digit(number[number.length-1],10))%10;
		if(s2 ==1)
			return true;
		else
			return false;
	}

	public static char ISO7812_Luhn_Generate(char[] number) throws NumberFormatException {
		int s1 = 0,	s2 = 0;
		char tmpchar = '0';
		for (int i = 0; i < number.length+1; i++) {
			if (i==0)
				tmpchar = '0';
			else
				tmpchar = number[number.length-i];

			int digit = Character.digit(tmpchar, 10);
			if(digit < 0) 
				throw new NumberFormatException(tmpchar+" is not a number");
			if (i % 2 == 0) {
				s1 += digit;   
			}else{
				s2 += 2 * digit;
				if(digit >= 5){
					s2 -= 9;
				}
			}
		}
		int val = (s1 + s2) % 10;
		if(val==0) 
			return '0';
		else
			return Character.forDigit(10-val,10);
	}
	public static boolean ISO7812_Luhn_Verify(char[] number) throws NumberFormatException  {
		int s1 = 0,	s2 = 0;
		for (int i = 0; i < number.length; i++) {
			int digit = Character.digit(number[number.length-1-i], 10);
			if(digit < 0) 
				throw new NumberFormatException(number[number.length-1-i]+" is not a number");
			if (i % 2 == 0) {
				s1 += digit;   
			}else{
				s2 += 2 * digit;
				if(digit >= 5){
					s2 -= 9;
				}
			}
		}
		return (s1 + s2) % 10 == 0;
	}
	public static char ISO15420_EAN13_Generate(char[] number) throws NumberFormatException {
		int s1 = 0,	s2 = 0;
		char tmp12bitCharArray[] = new char[12];
		if(number.length < 12)
				throw new NumberFormatException("need a 12bit number");
		else{
	        //char tmpV0SeedCharArray[] = new char[A12charArray.length + 5];
	        System.arraycopy(number, 0, tmp12bitCharArray, 0, 12);
		}
		for (int i = 0; i < 12; i++) {
			int digit = Character.digit(tmp12bitCharArray[11-i], 10);
			if(digit < 0) 
				throw new NumberFormatException(tmp12bitCharArray[11-i]+" is not a number");
			if (i % 2 == 0) {
				s1 += 3 * digit;   
			}else{
				s2 += digit;
			}
		}
		int val = (s1 + s2) % 10;
		if(val==0) 
			return '0';
		else
			return Character.forDigit(10-val,10);
	}
	public static boolean ISO15420_EAN13_Verify(char[] number) throws NumberFormatException {
		int s1 = 0,	s2 = 0;
		if(number.length != 13)
				throw new NumberFormatException("need a 13bit number");

		for (int i = 0; i < 12; i++) {
			int digit = Character.digit(number[11-i], 10);
			if(digit < 0) 
				throw new NumberFormatException(number[11-i]+" is not a number");
			if (i % 2 == 0) {
				s1 += 3 * digit;   
			}else{
				s2 += digit;
			}
		}
		int val = (s1 + s2) % 10;
		char c1 ;
		if(val==0) 
			c1='0';
		else
			c1= Character.forDigit(10-val,10);

		return c1 == number[number.length-1];
	}

}
