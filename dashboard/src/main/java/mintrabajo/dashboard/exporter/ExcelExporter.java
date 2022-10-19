package mintrabajo.dashboard.exporter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import mintrabajo.dashboard.entity.DashboardEntity;

public class ExcelExporter {
	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;

	private List<DashboardEntity> listDashboardEntity;

	public ExcelExporter() {
		workbook = new SXSSFWorkbook();
	}

	public ExcelExporter(List<DashboardEntity> listDashboardEntity) {
		this.listDashboardEntity = listDashboardEntity;
		workbook = new SXSSFWorkbook();
		workbook.setCompressTempFiles(true);
	}

	private void writeDashboardHeaderLine() {
		sheet =(SXSSFSheet) workbook.createSheet("Dashboard");
		sheet.setRandomAccessWindowSize(100);
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		createCell(row, 0, "idExpediente", style);
		createCell(row, 1, "numeroRadicacion", style);
		createCell(row, 2, "origenActuacion", style);
		createCell(row, 3, "estadoProceso", style);
		createCell(row, 4, "naturalezaInvestigacion", style);
		createCell(row, 5, "resumenQuerellantes", style);
		createCell(row, 6, "resumenQuerellados", style);
		createCell(row, 7, "estadoActividad", style);
		createCell(row, 8, "perfilActivo", style);
		createCell(row, 9, "actividadActual", style);
		createCell(row, 10, "etapaActual", style);
		createCell(row, 11, "etapaActualDesc", style);
		createCell(row, 12, "flujoActual", style);
		createCell(row, 13, "cadenaFlujo", style);
		createCell(row, 14, "organigramaRadicado", style);
		createCell(row, 15, "grupoRepartoInicial", style);	
		createCell(row, 16, "territorialRepartoInicial", style);
		createCell(row, 17, "usuarioReparto", style);
		createCell(row, 18, "organigramaNombreReparto", style);
		createCell(row, 19, "usuarioDirectorioActivo", style);
		createCell(row, 20, "usuarioEstado", style);
		createCell(row, 21, "ciuuQuerellado", style);
		createCell(row, 22, "ciuuCodigoQuerellado", style);
		createCell(row, 23, "sectorCriticoQuerellado", style);
		createCell(row, 24, "sectorCriticoDescQuerellado", style);
		createCell(row, 25, "tipoRecurso", style);
		createCell(row, 26, "fechaRadicacion", style);
		createCell(row, 27, "fechaHechos", style);
		createCell(row, 28, "fechaHechosFin", style);
		createCell(row, 29, "fechaPrescripcion", style);
		createCell(row, 30, "fechaPreasignacionReparto", style);
		createCell(row, 31, "fechaReparto", style);	
		createCell(row, 32, "valorSancion", style);
		createCell(row, 33, "tipoDecision", style);
		createCell(row, 34, "criterioGraduacionSancion", style);
		createCell(row, 35, "ejecutante", style);
		createCell(row, 36, "infraccion", style);
		createCell(row, 37, "tipoInfraccion", style);
		createCell(row, 38, "tipoSancion", style);
		createCell(row, 39, "materiaConducta", style);
		createCell(row, 40, "flujoPk", style);				
	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		//sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		cell.setCellStyle(style);
		try {
			if (value instanceof Integer) {
				cell.setCellValue((Integer) value);
			} else if (value instanceof Boolean) {
				cell.setCellValue((Boolean) value);
			} else if (value instanceof Long) {
				cell.setCellValue((Long) value);
			} else if (value instanceof Date) {
				CreationHelper createHelper = workbook.getCreationHelper();  
				 CellStyle cellStyle = workbook.createCellStyle();  
		            cellStyle.setDataFormat(  
		                createHelper.createDataFormat().getFormat("dd/mm/yyyy hh:mm"));  
				cell.setCellValue((Date) value);
				cell.setCellStyle(cellStyle);  
			} else {
				cell.setCellValue((String) value);
			}
		} catch (Exception e) {
			cell.setBlank();
		}
		
	}
	private void writeDashboardDataLines() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        
        for (DashboardEntity d : listDashboardEntity) {
        	
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, d.getIdExpediente(), style);
            createCell(row, columnCount++, d.getNumeroRadicacion(), style);
            createCell(row, columnCount++, d.getOrigenActuacion(), style);
            createCell(row, columnCount++, d.getEstadoProceso(), style);
            createCell(row, columnCount++, d.getNaturalezaInvestigacion(), style);
            
            createCell(row, columnCount++, d.getResumenQuerellantes(), style);
            createCell(row, columnCount++, d.getResumenQuerellados(), style);
            createCell(row, columnCount++, d.getEstadoActividad(), style);
            createCell(row, columnCount++, d.getPerfilActivo(), style);
            createCell(row, columnCount++, d.getActividadActual(), style);
            
            createCell(row, columnCount++, d.getEtapaActual(), style);
            createCell(row, columnCount++, d.getEtapaActualDesc(), style);
            createCell(row, columnCount++, d.getFlujoActual(), style);
            createCell(row, columnCount++, d.getCadenaFlujo(), style);
            createCell(row, columnCount++, d.getOrganigramaRadicado(), style);
            
            createCell(row, columnCount++, d.getGrupoRepartoInicial(), style);
            createCell(row, columnCount++, d.getTerritorialRepartoInicial(), style);
            createCell(row, columnCount++, d.getUsuarioReparto(), style);
            createCell(row, columnCount++, d.getOrganigramaNombreReparto(), style);
            createCell(row, columnCount++, d.getUsuarioDirectorioActivo(), style);

            createCell(row, columnCount++, d.getUsuarioEstado(), style);
            createCell(row, columnCount++, d.getCiuuQuerellado(), style);
            createCell(row, columnCount++, d.getCiuuCodigoQuerellado(), style);
            createCell(row, columnCount++, d.getSectorCriticoQuerellado(), style);
            createCell(row, columnCount++, d.getSectorCriticoDescQuerellado(), style);
            
            createCell(row, columnCount++, d.getTipoRecurso(), style);
            createCell(row, columnCount++, d.getFechaRadicacion(), style);
            createCell(row, columnCount++, d.getFechaHechos(), style);
            createCell(row, columnCount++, d.getFechaHechosFin(), style);
            createCell(row, columnCount++, d.getFechaPrescripcion(), style);
            
            createCell(row, columnCount++, d.getFechaPreasignacionReparto(), style);
            createCell(row, columnCount++, d.getFechaReparto(), style);
            createCell(row, columnCount++, d.getValorSancion(), style);
            createCell(row, columnCount++, d.getTipoDecision(), style);
            createCell(row, columnCount++, d.getCriterioGraduacionSancion(), style);
            
            createCell(row, columnCount++, d.getEjecutante(), style);
            createCell(row, columnCount++, d.getInfraccion(), style);
            createCell(row, columnCount++, d.getTipoInfraccion(), style);
            createCell(row, columnCount++, d.getTipoSancion(), style);
            createCell(row, columnCount++, d.getMateriaConducta(), style);
            createCell(row, columnCount++, d.getFlujoPk(), style);
        }
    }
	
	  public void exportDashboard(HttpServletResponse response) throws IOException {
		  	writeDashboardHeaderLine();
			writeDashboardDataLines();
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	        outputStream.close();
	    }
}
