import tensorflow as tf

state = tf.Variable(1 , name = 'counter') # bianliang 
print(state.name)
print(state)

one = tf.constant(1) #changliang

new_value = tf.add(state , one)
update = tf.assign(state, new_value)   #state = new_value

init = tf.initialize_all_variables() #chu shi hua suo you bianliang

with tf.Session() as sess:
	sess.run(init)
	for _ in range(3):
		sess.run(update)
		print(sess.run(state))
