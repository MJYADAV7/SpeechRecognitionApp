
from __future__ import division
import numpy as np
from scipy.io.wavfile import read
from LBG import EUDistance
from MFCC_algorithm import mfcc
from train import training
import os


l=["Durjoy","Prakash","Manjeet","Rohit"]
#calculating the minimum distance between neighbours
def minDistance(features, codebooks):
    speaker = 0
    distmin = np.inf
    for k in range(np.shape(codebooks)[0]):
        D = EUDistance(features, codebooks[k,:,:])
        dist = np.sum(np.min(D, axis = 1))/(np.shape(D)[0])
        if dist < distmin:
            distmin = dist
            speaker = k
    distmin = 100 - int(distmin)
    if(distmin<30):
        return "Unknown person speaking"
    else:
        return  l[speaker]+" Is Current Speaker with "+str(distmin)+"% matches"
    

def main(fname):
    #total  filters required
    nfilters = 16
    #assigning the location of testing data
    directory = os.path.abspath(os.path.dirname(__file__))

    codebooks = training(nfilters)

    #performing testing
    directory = directory+'/test/'+fname + '.wav'
    (fs,s) = read(directory)
    mel_coefs = mfcc(s,fs,nfilters)
    return minDistance(mel_coefs, codebooks)




    
