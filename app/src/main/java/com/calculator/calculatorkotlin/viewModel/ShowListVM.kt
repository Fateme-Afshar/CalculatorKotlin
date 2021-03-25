package com.calculator.calculatorkotlin.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.model.CalculateModel
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileOutputStream


class ShowListVM(private val calculatorRepository: CalculatorRepository,private val application: Application) : ViewModelProvider.Factory {
    private val filePath: File = File(application.getExternalFilesDir("ExcelFile"), "test41.xls")
    private var calculatorList = mutableListOf<CalculateModel>()

    fun onSaveBtnClickListener() {
        val hssfWorkbook = HSSFWorkbook()
        val hssfSheet = hssfWorkbook.createSheet("Custom Sheet")

        val hssfRowMain = hssfSheet.createRow(0)
        hssfRowMain.createCell(0).setCellValue("result")
        hssfRowMain.createCell(1).setCellValue("point1-x")
        hssfRowMain.createCell(2).setCellValue("point1-y")
        hssfRowMain.createCell(3).setCellValue("point2-x")
        hssfRowMain.createCell(4).setCellValue("point2-y")

        for (i in 0 until calculatorList.size) {
            val hssfRow = hssfSheet.createRow(i+1)
            hssfRow.createCell(0).setCellValue(calculatorList[i].result.toString())
            hssfRow.createCell(1)
                .setCellValue(calculatorList[i].listOfDirectionModel[0].x.toString())
            hssfRow.createCell(2)
                .setCellValue(calculatorList[i].listOfDirectionModel[0].y.toString())
            hssfRow.createCell(3)
                .setCellValue(calculatorList[i].listOfDirectionModel[1].x.toString())
            hssfRow.createCell(4)
                .setCellValue(calculatorList[i].listOfDirectionModel[1].y.toString())
        }

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

    fun setCalculateList(calculatorList: List<CalculateModel>) {
        this.calculatorList = calculatorList as MutableList<CalculateModel>
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShowListVM(calculatorRepository, application) as T
    }
}