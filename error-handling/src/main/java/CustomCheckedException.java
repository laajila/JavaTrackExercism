class CustomCheckedException extends Exception {
    private Exception customChecked;
    CustomCheckedException()  {
        customChecked= new Exception("checked exception.");
    }

    CustomCheckedException(String message)  {
        customChecked= new Exception(message);
    }

}
