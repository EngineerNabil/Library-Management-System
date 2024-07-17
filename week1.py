import hashlib
hashvalue = '99771' 
hashobject = hashlib.sha1()
hashobject.update(hashvalue.encode())
print(hashobject.hexdigest())