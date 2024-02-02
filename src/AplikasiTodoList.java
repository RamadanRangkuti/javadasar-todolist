public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        String name = input("nama");
        System.out.println("Hi " + name);
    }
//    menampilkan view todolist
    public static void showTodoList(){
        System.out.println("-----TODO LIST------");
        for(int i=0; i< model.length; i++){
            var todo = model[i];
            int no = i+1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

//    unitest
    public static void testShowTodoList(){
        model[0]="Belajar Java Dasar";
        model[1]="Studi Kasus Java Dasar : Membuat Aplikasi TodoList";
        showTodoList();
    }

//    menampilkan view menambah todolist
    public static void addTodoList(String todo){
        var isFull = true;
//        cek apakah model penuh?
        for(var i=0; i<model.length; i++){
            if(model[i]==null){
//                model masih ada yang kosong
                isFull = false;
                break;
            }
        }

//        jika penuh ukuran array 2x lipat
        if(isFull){
            String[] temp = model;
            //resize array model
            model = new String[model.length *2];

            for(int i=0; i< temp.length; i++){
                model[i]=temp[i];
            }
        }

//        tambahkan ke posisi yang data arraynya null
        for(var i= 0; i<model.length; i++){
            if(model[i]==null){
                model[i]=todo;
                break;
            }
        }
    }

//    test addTodoList
    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("contoh toda ke :" + i);
        }

        showTodoList();
    }

//    menghapus todo dari list
    public static boolean removeTodoList(Integer number){
        if((number-1)>= model.length){
            return false;
        }else if(model[number-1]==null){
            return false;
        }else {
            model[number-1] = null;
            for (int i = (number-1); i < model.length; i++) {
                if(i == model.length-1){
                    model[i] = null;
                }else {
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        boolean result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(4);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

//    menampilkan view todolist
    public static void viewShowTodoList(){
        while (true){
            showTodoList();
            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("Pilih");
            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }
            else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        viewShowTodoList();
    }

//    menampilkan menambahkan todolist
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");
        String todo = input("Todo (x Jika Batal)");

        if(todo.equals("x")){

        }else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        viewAddTodoList();
        showTodoList();
    }

//    menampilkan menghapus todolist
    public static void viewRemoveTodoList(){
        System.out.println("HAPUS TODOLIST");
        String number = input("Nomor yang dihapus (x Jika Batal)");
        if(number.equals("x")){
            //batal
        }else{
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
