import java.util.Collection;

public class Twelve implements CustomCollection{

    protected String[] array;
    protected int count = 0;

    public Twelve(){
        this.array = new String[10];
    }

    @Override
    public boolean add(String str) {
        if (this.count == this.array.length){
            String[] newArray = new String[count + count * 2 / 3];
            for (int i = 0; i < this.array.length; i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
            this.count++;
            this.array[count - 1] = str;
            return true;
        }else {
            this.array[count] = str;
            this.count++;
            return true;
        }
    }

    @Override
    public boolean addAll(String[] strArr) {
        int i = 0;
        while (i < strArr.length) {
            add(strArr[i]);
            i++;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        String[] stockArr = (String[]) strColl.toArray(new String[strColl.size()]);
        addAll(stockArr);
        return true;
    }

    @Override
    public boolean delete(int index) {
        if ( index >= 0 && index < this.array.length) {
            for (int i = 0; i < this.array.length - 1; i++) {
                if (i >= index) {
                    this.array[i] = this.array[i + 1];
                }
            }
            this.array[this.array.length - 1] = null;
            this.count--;
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String str) {
        if (contains(str)){
            for (int i = 0; i < this.array.length - 1; i++) {
                if (this.array[i].equals(str)) {
                    while ( i < this.array.length - 1){
                        this.array[i] = this.array[i + 1];
                        i++;
                    }
                }
            }
            this.array[this.array.length - 1] = null;
            this.count--;
            return true;
        }
        return false;
    }

    @Override
    public String get(int index) {
        if ( index >= 0 && index < this.array.length) {
            for (int i = 0; i < this.array.length ; i++) {
                if (i == index) {
                    return this.array[i];
                }
            }
        }
        return "Index is out of range";
    }

    public boolean contains(String newString){
        for (int i = 0; i < this.array.length; i++){
            try{
                if ( this.array[i].equals(newString)) return true;
            }catch (NullPointerException ex){
                return false;
            }
        }
      return false;
    }

    @Override
    public boolean clear() {
        this.array = new String[10];
        this.count = 0;
        return true;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean trim() {
        int countForNulls = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                countForNulls++;
            }
        }
        if (countForNulls == 0) return false;
        String[] newArray = new String[this.array.length - countForNulls];
            for (int j = 0; j < this.array.length - countForNulls; j++){
                newArray[j] = this.array[j];
            }
            this.array = newArray;
            return true;
    }

    @Override
    public boolean compare(Collection coll) {
        String[] stockArr = (String[]) coll.toArray(new String[coll.size()]);
        boolean flag = false;
        for(int i = 0; i < stockArr.length; i++){
            if ( contains(stockArr[i]) ) flag = true;
        }
        return flag;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
