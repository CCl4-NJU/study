import pandas as pd
from skimage import io, transform
import numpy as np

w = 173
h = 128
c = 4

def read_train_img():
    imgs = []
    labels = []
    train_csv_data = pd.read_csv('./data/train_labels.csv')
    for index in range(0, train_csv_data.__len__()):
        pic_name = train_csv_data['file_id'][index]
        pic_label = train_csv_data['accent'][index]
        pic_path = './data/train/' + str(pic_name) + '.png'
        print("reading the train images: " + str(pic_name) + ".png")
        print("the train image label is: " + str(pic_label))
        img = io.imread(pic_path)
        img = transform.resize(img, (w, h))
        print("the train image's channel is: " + str(img.shape))
        imgs.append(img)
        labels.append(pic_label)
    return np.asarray(imgs, np.float32), np.asarray(labels, np.int32)

def read_test_img():
    imgs = []
    labels = []
    test_csv_data = pd.read_csv('./data/submission_format.csv')
    for index in range(0, test_csv_data.__len__()):
        pic_name = test_csv_data['file_id'][index]
        pic_label = test_csv_data['accent'][index]
        pic_path = './data/test/' + str(pic_name) + '.png'
        print("reading the test images: " + str(pic_name) + ".png")
        print("the test image label is: " + str(pic_label))
        img = io.imread(pic_path)
        img = transform.resize(img, (w, h))
        print("the test image's channel is: " + str(img.shape))
        imgs.append(img)
        labels.append(pic_label)
    return np.asarray(imgs, np.float32), np.asarray(labels, np.int32)