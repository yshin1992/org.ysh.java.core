package org.ysh.java.core.simpletools;

public class String2UnicodeTool {

	private static final String ENGLISTH_CHARACTERS="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ·~!@#$%^&*()_+-=[]\\{}|:\";'<>?,./";
	
	private static final String CHINESE_CHARACTERS="，。、《》？：“；’【】、·！@#￥%……&*（）——+-=";
	
	public static final String string2Unicode(String chinese) {

		if (null != chinese) {
			StringBuilder unicode = new StringBuilder();
			for (int i = 0; i < chinese.length(); i++) {
				char c = chinese.charAt(i);
				if(ENGLISTH_CHARACTERS.indexOf(c)!= -1 || CHINESE_CHARACTERS.indexOf(c)!=-1){
					unicode.append(c);
				}else{
					unicode.append("\\u");
					//高8位
//					int high = c >>> 8;
//					String tmp = Integer.toHexString(high);
//					if(tmp.length() == 1)
//					{
//						unicode.append("0");
//					}
//					unicode.append(tmp);
//					
//					int low = c & 0xFF;
//					tmp = Integer.toHexString(low);
//					if(tmp.length() == 1)
//					{
//						unicode.append("0");
//					}
					String tmp = Integer.toHexString(c);
					if(tmp.length() == 2)
					{
						unicode.append("00");
					}
					unicode.append(tmp);
				}
			}
			return unicode.toString();
		}
		return null;
	}
	
	public static final String unicode2String(String unicode)
	{
		if(null != unicode)
		{
			//如果不是unicode编码则直接返回
			if(unicode.indexOf("\\u") == -1)
			{
				return unicode;
			}
			
			StringBuilder builder = new StringBuilder();
			int start = unicode.indexOf("\\u");
			
			if(start!=0){
				builder.append(unicode.substring(0,start));
			}
			
			int end = 0;
			
			while(start > -1)
			{
				//下一个\\u的位置
				end = unicode.indexOf("\\u",start + 2);
				String tmp = "";
				tmp = unicode.substring(start+2,start+6);
				char letter = (char) Integer.parseInt(tmp,16);
				builder.append(new Character(letter).toString());
				if(end == -1){
					//下一个位置是-1则表示剩下的字符中没有Unicode字符了
					builder.append(unicode.substring(start+6));
				}else{
					if(end-start> 6){ 
						//判断字符的间距是否大于6个字符，如果大于6个，则说明有其他字符
						builder.append(unicode.substring(start+6,end));
					}
				}
				start = end;
			}
			return builder.toString();
		}
		return null;
	}
}
