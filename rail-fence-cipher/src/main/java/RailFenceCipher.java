class RailFenceCipher {
    RailFenceCipher(int x) {

    }

    String getDecryptedData(String cryptedInput) {
        //size devided by 4 & + 1 if any reminder  first array size
        int firstRowSize = cryptedInput.length() / 4 + ((cryptedInput.length() % 4 == 0) ? 0 : 1);
        //(size devided by 4)*2 & + 1 if reminder is 2 or 3
        int secondRowSize = cryptedInput.length() / 2 + ((cryptedInput.length() % 4 == 1) ? 0 : 1);
        //size devided by 4 & + 1 if reminder 3
        int thirdRowSize = cryptedInput.length() / 4 + ((cryptedInput.length() % 4 == 3) ? 1 : 0);
        System.out.println(firstRowSize + "&" + secondRowSize + "&" + thirdRowSize);
        String row1Cipher = cryptedInput.substring(0, firstRowSize);
        String row2Cipher = cryptedInput.substring(firstRowSize, firstRowSize + secondRowSize);
        String row3Cipher = cryptedInput.substring(firstRowSize + secondRowSize, firstRowSize + secondRowSize + thirdRowSize);
        System.out.println(row1Cipher + "&" + row2Cipher + "&" + row3Cipher);
        StringBuilder decyphred = new StringBuilder();
        for (int i = 0; i < firstRowSize; i++) {
            decyphred.append(row1Cipher.charAt(i));
            if (i * 2 < secondRowSize) decyphred.append(row2Cipher.charAt(i * 2));
            if (i < thirdRowSize) decyphred.append(row3Cipher.charAt(i));
            if (i * 2 + 1 < secondRowSize) decyphred.append(row2Cipher.charAt(i * 2 + 1));
        }


        return decyphred.toString();
    }

    String getEncryptedData(String clearInput) {

        return "yeah";
    }
}