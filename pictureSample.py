import sys
from PyQt4 import QtGui, QtCore

class Admin(QtGui.QMainWindow):
	def __init__(self):
		super(Admin, self).__init__()
		self.setGeometry(50, 50, 699, 538)
		self.setWindowTitle("picture sample")
		self.home()
	def home(self):

		pic = QtGui.QLabel('', self)
		pic.move(40,240)
		pic.resize(311,241)
		pixmap = QtGui.QPixmap("/home/pravin/self/redrock.jpg")
		pixmap = pixmap.scaledToHeight(200)
		pic.setPixmap(pixmap)

		self.show()
	
		

		
		
		
def main():
	app = QtGui.QApplication(sys.argv)
	GUI = Admin()
	sys.exit(app.exec_())
main()

