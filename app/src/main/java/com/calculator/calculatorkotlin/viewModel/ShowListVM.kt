package com.calculator.calculatorkotlin.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileOutputStream


class ShowListVM(private val calculatorRepository: CalculatorRepository,private val application: Application) : ViewModelProvider.Factory {
    private val filePath: File = File(application.getExternalFilesDir("ExcelFile"),"test.xls")
    fun onSaveBtnClickListener(){
        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet = hssfWorkbook.createSheet("Custom Sheet")

        val hssfRow = hssfSheet.createRow(0)
        val hssfCell = hssfRow.createCell(0)

        hssfCell.setCellValue("Test")

        try {
            if (!filePath.exists()) {
                filePath.createNewFile()
            }
            val fileOutputStream = FileOutputStream(filePath)
            hssfWorkbook.write(fileOutputStream)
            if (fileOutputStream != null) {
                fileOutputStream.flush()
                fileOutputStream.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShowListVM(calculatorRepository,application) as T
    }
}