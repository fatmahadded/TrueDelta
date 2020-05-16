import yfinance as yf
import pandas as pd
from datetime import datetime
args = __import__('sys').argv
symbol = args[1]
data = yf.Ticker(symbol)
history = data.history(period='1d', start='2010-1-1', end=datetime.today().strftime('%Y-%m-%d'))

with pd.option_context('display.max_rows', None, 'display.max_columns', None):
    print(history)