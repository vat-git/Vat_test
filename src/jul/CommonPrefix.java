package jul;

public class CommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
        public static String longestCommonPrefix(String[] strs) {


            int end =strs[0].length()-1;

            char[] begin = strs[0].toCharArray();

            for(int i=1;i<strs.length;i++){
                if(end<0){
                    return "";
                }
                char[] test = strs[i].toCharArray();
                if (test.length-1 < end) {
                    end = test.length-1;
                }
                for(int j=0;j<=end;j++){
                    if(begin[j]!=test[j]){
                        end = j-1;
                    }
                }
            }
            if (end >= 0) {
                String result = "";
                int count = 0;
                while (count  <end) {
                    result = result + begin[count];
                    count++;
                }
                return result;
            }
            return "";
        }

}
