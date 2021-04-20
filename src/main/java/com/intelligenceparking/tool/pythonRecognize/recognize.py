# 2021-4-20
# SoftEngineering Pro
# Environment: pip install hyperlpr
# python3.6
# opencv-python==3.4.3.18
import sys
import cv2
from hyperlpr import *

if __name__ == '__main__':
    imagePath = sys.argv[1]
    img = cv2.imread(imagePath)
    result = HyperLPR_plate_recognition(img)
    if(len(result)==0):
        print("null")
    else:
        print(result[0][0])
