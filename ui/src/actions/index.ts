export const TYPE_CLEAR_COMPLETED = 'CLEAR_COMPLETED';
export const TYPE_EDIT = 'EDIT';
export const TYPE_DESTROY = 'DESTROY';
export const TYPE_CHANGE_STATUS = 'CHANGE_STATUS';
export const TYPE_CHANGE_TODO = 'CHANGE_TODO';
export const TYPE_CANCEL = 'CANCEL';
export const TYPE_ADD_NEW_TODO = 'ADD_NEW_TODO';
export const TYPE_TOGGLE_ALL = 'TOGGLE_ALL';

export const clearCompleted = () => ({type: TYPE_CLEAR_COMPLETED});
export const editTodo = (id: number) => ({type: TYPE_EDIT, id});
export const destroyTodo = (id: number) => ({type: TYPE_DESTROY, id});
export const toggleTodo = (id: number, completed: boolean) => ({type: TYPE_CHANGE_STATUS, id, completed});
export const saveTodo = (id: number, text: string) => ({type: TYPE_CHANGE_TODO, id, text});
export const cancelTodo = (id: number) => ({type: TYPE_CANCEL, id});
export const newTodo = (value: string) => ({type: TYPE_ADD_NEW_TODO, value});
export const toggleAll = (completed: boolean) => ({type: TYPE_TOGGLE_ALL, completed});
